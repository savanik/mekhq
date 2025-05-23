/*
 * Copyright (c) 2009 Jay Lawson (jaylawson39 at yahoo.com). All rights reserved.
 * Copyright (C) 2013-2025 The MegaMek Team. All Rights Reserved.
 *
 * This file is part of MekHQ.
 *
 * MekHQ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License (GPL),
 * version 3 or (at your option) any later version,
 * as published by the Free Software Foundation.
 *
 * MekHQ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * A copy of the GPL should have been included with this project;
 * if not, see <https://www.gnu.org/licenses/>.
 *
 * NOTICE: The MegaMek organization is a non-profit group of volunteers
 * creating free software for the BattleTech community.
 *
 * MechWarrior, BattleMech, `Mech and AeroTech are registered trademarks
 * of The Topps Company, Inc. All Rights Reserved.
 *
 * Catalyst Game Labs and the Catalyst Game Labs logo are trademarks of
 * InMediaRes Productions, LLC.
 */
package mekhq.campaign.parts;

import java.util.Objects;

import megamek.common.EquipmentType;
import megamek.common.equipment.ArmorType;
import mekhq.campaign.Campaign;
import mekhq.campaign.finances.Money;
import mekhq.campaign.work.IAcquisitionWork;

/**
 * @author Jay Lawson (jaylawson39 at yahoo.com)
 */
public class BaArmor extends Armor {
    public static boolean canBeClan(int type) {
        return type == EquipmentType.T_ARMOR_BA_STANDARD || type == EquipmentType.T_ARMOR_BA_STEALTH_BASIC
                || type == EquipmentType.T_ARMOR_BA_STEALTH_IMP || type == EquipmentType.T_ARMOR_BA_STEALTH
                || type == EquipmentType.T_ARMOR_BA_FIRE_RESIST;
    }

    public static boolean canBeIs(int type) {
        return type != EquipmentType.T_ARMOR_BA_FIRE_RESIST;
    }

    public static double getPointsPerTon(int t, boolean isClan) {
        return 1.0 / ArmorType.of(t, isClan).getWeightPerPoint();
    }

    public BaArmor() {
        this(0, 0, 0, -1, false, null);
    }

    public BaArmor(int tonnage, int points, int type, int loc, boolean clan, Campaign c) {
        // Amount is used for armor quantity, not tonnage
        super(tonnage, type, points, loc, false, clan, c);
    }

    @Override
    public BaArmor clone() {
        BaArmor clone = new BaArmor(0, amount, type, location, clan, campaign);
        clone.copyBaseData(this);
        return clone;
    }

    @Override
    public double getTonnage() {
        return ArmorType.of(type, clan).getWeightPerPoint() * amount;
    }

    public Money getPointCost() {
        switch (type) {
            case EquipmentType.T_ARMOR_BA_STANDARD_ADVANCED:
                return Money.of(12500);
            case EquipmentType.T_ARMOR_BA_MIMETIC:
            case EquipmentType.T_ARMOR_BA_STEALTH:
                return Money.of(15000);
            case EquipmentType.T_ARMOR_BA_STEALTH_BASIC:
                return Money.of(12000);
            case EquipmentType.T_ARMOR_BA_STEALTH_IMP:
                return Money.of(20000);
            case EquipmentType.T_ARMOR_BA_STEALTH_PROTOTYPE:
                return Money.of(50000);
            case EquipmentType.T_ARMOR_BA_FIRE_RESIST:
            case EquipmentType.T_ARMOR_BA_STANDARD_PROTOTYPE:
            case EquipmentType.T_ARMOR_BA_STANDARD:
            default:
                return Money.of(10000);
        }
    }

    private double getPointsPerTon() {
        return getPointsPerTon(type, clan);
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public Money getActualValue() {
        return adjustCostsForCampaignOptions(getPointCost().multipliedBy(amount));
    }

    @Override
    public double getTonnageNeeded() {
        return amountNeeded / getPointsPerTon();
    }

    @Override
    public Money getValueNeeded() {
        return adjustCostsForCampaignOptions(getPointCost().multipliedBy(amountNeeded));
    }

    @Override
    public Money getStickerPrice() {
        // always in 5-ton increments
        return getPointCost().multipliedBy(5).multipliedBy(getPointsPerTon());
    }

    @Override
    public Money getBuyCost() {
        return getActualValue();
    }

    @Override
    public boolean isSamePartType(Part part) {
        return (getClass() == part.getClass())
                && (isClanTechBase() == part.isClanTechBase())
                && Objects.equals(getRefitUnit(), part.getRefitUnit())
                && (((BaArmor) part).getType() == getType());
    }

    @Override
    public boolean isSameStatus(Part part) {
        return !hasParentPart() && !part.hasParentPart() && this.getDaysToArrival() == part.getDaysToArrival();
    }

    @Override
    public double getArmorWeight(int points) {
        return points * 50 / 1000.0;
    }

    @Override
    public IAcquisitionWork getAcquisitionWork() {
        return new BaArmor(0, (int) Math.round(5 * getPointsPerTon()), type, -1, clan, campaign);
    }

    @Override
    public Part getNewPart() {
        return new BaArmor(0, (int) Math.round(5 * getPointsPerTon()), type, -1, clan, campaign);
    }

    @Override
    public int getAmountAvailable() {
        return campaign.getWarehouse()
                     .streamSpareParts()
                     .filter(this::isSameBAArmorPart)
                     .mapToInt(part -> ((BaArmor) part).getAmount())
                     .sum();
    }

    @Override
    protected int changeAmountAvailableSingle(int amount) {
        BaArmor armor = (BaArmor) campaign.getWarehouse()
                                        .findSparePart(part -> isSamePartType(part) && part.isPresent());

        if (null != armor) {
            int amountRemaining = armor.getAmount() + amount;
            armor.setAmount(amountRemaining);
            if (armor.getAmount() <= 0) {
                campaign.getWarehouse().removePart(armor);
                return Math.min(0, amountRemaining);
            }
        } else if (amount > 0) {
            campaign.getQuartermaster()
                  .addPart(new BaArmor(getUnitTonnage(), amount, type, -1, isClanTechBase(), campaign), 0, false);
        }
        return 0;
    }

    /**
     * Not sure how true this title is, it was used in {@link BaArmor#getAmountAvailable}
     * @param part is this part the same
     * @return true if the two parts are the same, at least as far as {@link BaArmor#getAmountAvailable} is concerned
     */
    private boolean isSameBAArmorPart(Part part) {
        return (part instanceof BaArmor armor) &&
                     armor.isPresent() &&
                     !armor.isReservedForRefit() &&
                     isClanTechBase() == part.isClanTechBase() &&
                     armor.getType() == getType();
    }
}
