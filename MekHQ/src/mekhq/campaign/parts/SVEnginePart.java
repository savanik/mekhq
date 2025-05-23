/*
 * Copyright (C) 2019-2025 The MegaMek Team. All Rights Reserved.
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

import java.io.PrintWriter;

import megamek.common.Aero;
import megamek.common.Engine;
import megamek.common.Entity;
import megamek.common.FuelType;
import megamek.common.ITechnology;
import megamek.common.Tank;
import megamek.common.TechAdvancement;
import megamek.common.TechConstants;
import megamek.common.annotations.Nullable;
import megamek.logging.MMLogger;
import mekhq.campaign.Campaign;
import mekhq.campaign.finances.Money;
import mekhq.campaign.parts.enums.PartRepairType;
import mekhq.campaign.personnel.skills.SkillType;
import mekhq.utilities.MHQXMLUtility;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Engine for a support vehicle. An identical support vehicle engine will have
 * the same engine type,
 * unit tonnage, tech rating, and movement factor. The movement factor is the
 * vehicle's (cruise/safe thrust)^2 + 4.
 * ICEs will also have the same fuel type.
 */
public class SVEnginePart extends Part {
    private static final MMLogger logger = MMLogger.create(SVEnginePart.class);

    private double engineTonnage;
    private int etype;
    private TechRating techRating;
    private FuelType fuelType;

    private TechAdvancement techAdvancement;

    /**
     * Constructor used during campaign deserialization
     */

    public SVEnginePart() {
        this(0, 0.0, Engine.COMBUSTION_ENGINE, TechRating.D, FuelType.PETROCHEMICALS, null);
    }

    /**
     * Creates a support vehicle engine part.
     *
     * @param unitTonnage   The mass of the unit it is installed on/intended for, in
     *                      tons.
     * @param engineTonnage The mass of the engine
     * @param etype         An {@link Engine} type constant
     * @param techRating    The engine's tech rating, {@code TechRating.A} through
     *                      {@code TechRating.F}
     * @param fuelType      Needed to distinguish different types of internal
     *                      combustion engines.
     * @param campaign      The campaign instance
     */
    public SVEnginePart(int unitTonnage, double engineTonnage, int etype, TechRating techRating,
            FuelType fuelType, Campaign campaign) {
        super(unitTonnage, campaign);
        this.engineTonnage = unitTonnage;
        this.etype = etype;
        this.techRating = techRating;
        this.fuelType = fuelType;

        Engine engine = new Engine(10, etype, Engine.SUPPORT_VEE_ENGINE);
        techAdvancement = engine.getTechAdvancement();
        name = String.format("%s (%s) Engine", engine.getEngineName(), techRating.getName());
    }

    /**
     * @return The weight of the engine
     */
    public double getEngineTonnage() {
        return engineTonnage;
    }

    /**
     * @return The {@link Engine} type flag
     */
    public int getEType() {
        return etype;
    }

    @Override
    public TechRating getTechRating() {
        return techRating;
    }

    /**
     * Internal combustion engines differ by the type of fuel they are designed for.
     *
     * @return The type of fuel used by the engine.
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public SVEnginePart clone() {
        SVEnginePart engine = new SVEnginePart(getUnitTonnage(), engineTonnage, etype, techRating,
                fuelType, getCampaign());
        engine.copyBaseData(this);
        return engine;
    }

    @Override
    public double getTonnage() {
        return engineTonnage;
    }

    @Override
    public Money getStickerPrice() {
        return Money.of(5000 * getTonnage() * Engine.getSVCostMultiplier(etype));
    }

    @Override
    public boolean isSamePartType(Part other) {
        return other instanceof SVEnginePart
                && (engineTonnage == ((SVEnginePart) other).engineTonnage)
                && (etype == ((SVEnginePart) other).etype)
                && (techRating == ((SVEnginePart) other).techRating)
                && ((etype != Engine.COMBUSTION_ENGINE) || (fuelType == ((SVEnginePart) other).fuelType));
    }

    @Override
    public int getTechLevel() {
        return TechConstants.T_IS_TW_NON_BOX;
    }

    private static final String NODE_ENGINE_TONNAGE = "engineTonnage";
    private static final String NODE_ETYPE = "etype";
    private static final String NODE_TECH_RATING = "techRating";
    private static final String NODE_FUEL_TYPE = "fuelType";

    @Override
    public void writeToXML(final PrintWriter pw, int indent) {
        indent = writeToXMLBegin(pw, indent);
        MHQXMLUtility.writeSimpleXMLTag(pw, indent, NODE_ENGINE_TONNAGE, engineTonnage);
        MHQXMLUtility.writeSimpleXMLTag(pw, indent, NODE_ETYPE, etype);
        MHQXMLUtility.writeSimpleXMLTag(pw, indent, NODE_TECH_RATING, techRating.getName());
        if (etype == Engine.COMBUSTION_ENGINE) {
            MHQXMLUtility.writeSimpleXMLTag(pw, indent, NODE_FUEL_TYPE, fuelType.name());
        }
        writeToXMLEnd(pw, indent);
    }

    @Override
    public void loadFieldsFromXmlNode(Node node) {
        NodeList nl = node.getChildNodes();
        for (int x = 0; x < nl.getLength(); x++) {
            final Node wn = nl.item(x);
            try {
                switch (wn.getNodeName()) {
                    case NODE_ENGINE_TONNAGE:
                        engineTonnage = Double.parseDouble(wn.getTextContent());
                        break;
                    case NODE_ETYPE:
                        etype = Integer.parseInt(wn.getTextContent());
                        break;
                    case NODE_TECH_RATING:
                        techRating = TechRating.fromName(wn.getTextContent());
                        break;
                    case NODE_FUEL_TYPE:
                        fuelType = FuelType.valueOf(wn.getTextContent());
                        break;
                }
            } catch (Exception e) {
                logger.error("", e);
            }
        }
    }

    @Override
    public void fix() {
        super.fix();
        if (null != unit) {
            if (unit.getEntity() instanceof Tank) {
                ((Tank) unit.getEntity()).engineFix();
            } else if (unit.getEntity() instanceof Aero) {
                ((Aero) unit.getEntity()).setEngineHits(0);
            }
        }
    }

    @Override
    public MissingPart getMissingPart() {
        return new MissingSVEngine(getUnitTonnage(), engineTonnage, etype, techRating,
                fuelType, getCampaign());
    }

    @Override
    public void remove(boolean salvage) {
        if (null != unit) {
            if (unit.getEntity() instanceof Tank) {
                ((Tank) unit.getEntity()).engineHit();
            } else if (unit.getEntity() instanceof Aero) {
                ((Aero) unit.getEntity()).setEngineHits(((Aero) unit.getEntity()).getMaxEngineHits());
            }
            Part spare = campaign.getWarehouse().checkForExistingSparePart(this);
            if (!salvage) {
                campaign.getWarehouse().removePart(this);
            } else if (null != spare) {
                spare.incrementQuantity();
                campaign.getWarehouse().removePart(this);
            }
            unit.removePart(this);
            Part missing = getMissingPart();
            unit.addPart(missing);
            campaign.getQuartermaster().addPart(missing, 0);
        }
        setUnit(null);
        updateConditionFromEntity(false);
    }

    @Override
    public void updateConditionFromEntity(boolean checkForDestruction) {
        if (null != unit) {
            int engineHits = 0;
            int engineCrits = 0;
            if (unit.getEntity() instanceof Tank) {
                engineCrits = 2;
                if (((Tank) unit.getEntity()).isEngineHit()) {
                    engineHits = 1;
                }
            } else if (unit.getEntity() instanceof Aero) {
                engineHits = unit.getEntity().getEngineHits();
                engineCrits = 3;
            }
            if (engineHits >= engineCrits) {
                remove(false);
            } else {
                hits = Math.max(engineHits, 0);
            }
        }
    }

    @Override
    public int getBaseTime() {
        if (isSalvaging()) {
            return 360;
        }
        // 100 minutes per hit, to a maximum of 300 minutes
        return Math.min(300, hits * 100);
    }

    @Override
    public int getDifficulty() {
        if (isSalvaging()) {
            return -1;
        }
        if (hits == 1) {
            return -1;
        } else if (hits == 2) {
            return 0;
        } else if (hits > 2) {
            return 2;
        }
        return 0;
    }

    @Override
    public boolean needsFixing() {
        return hits > 0;
    }

    @Override
    public void updateConditionFromPart() {
        if (null != unit) {
            if (hits == 0) {
                if (unit.getEntity() instanceof Tank) {
                    ((Tank) unit.getEntity()).engineFix();
                } else if (unit.getEntity() instanceof Aero) {
                    ((Aero) unit.getEntity()).setEngineHits(0);
                }
            } else {
                if (unit.getEntity() instanceof Tank) {
                    ((Tank) unit.getEntity()).engineHit();
                } else if (unit.getEntity() instanceof Aero) {
                    ((Aero) unit.getEntity()).setEngineHits(hits);
                }
            }
        }
    }

    @Override
    public @Nullable String checkFixable() {
        return null;
    }

    @Override
    public boolean isMountedOnDestroyedLocation() {
        return false;
    }

    @Override
    public boolean isRightTechType(String skillType) {
        if (null != getUnit()) {
            if (getUnit().getEntity() instanceof Aero) {
                return skillType.equals(SkillType.S_TECH_AERO);
            } else {
                return skillType.equals(SkillType.S_TECH_MECHANIC);
            }
        }
        // We're not tracking whether parts in the warehouse came from ground or
        // fixed-wing/airships,
        // so let either tech repair it.
        return (skillType.equals(SkillType.S_TECH_AERO) || skillType.equals(SkillType.S_TECH_MECHANIC));
    }

    @Override
    public String getLocationName() {
        if (null != unit) {
            return unit.getEntity().getLocationName(unit.getEntity().getBodyLocation());
        }
        return null;
    }

    @Override
    public int getLocation() {
        if (null != unit) {
            return unit.getEntity().getBodyLocation();
        }
        return Entity.LOC_NONE;
    }

    @Override
    public TechAdvancement getTechAdvancement() {
        return techAdvancement;
    }

    @Override
    public PartRepairType getMRMSOptionType() {
        return PartRepairType.ENGINE;
    }
}
