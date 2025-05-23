/*
 * Copyright (C) 2025 The MegaMek Team. All Rights Reserved.
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
 *
 * MechWarrior Copyright Microsoft Corporation. MekHQ was created under
 * Microsoft's "Game Content Usage Rules"
 * <https://www.xbox.com/en-US/developers/rules> and it is not endorsed by or
 * affiliated with Microsoft.
 */
package mekhq.campaign.randomEvents.personalities.enums;

import static mekhq.utilities.MHQInternationalization.isResourceKeyValid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import megamek.common.enums.Gender;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

public class SocialTest {
    @ParameterizedTest
    @CsvSource(value = { "APATHETIC,APATHETIC", "INVALID_STATUS,NONE", "'',NONE", "'null',NONE", "1,APATHETIC" })
    void testFromStringVariousInputs(String input, Social expected) {
        if ("null".equals(input)) {
            input = null;
        }
        Social result = Social.fromString(input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource(value = Social.class)
    void testFromString_Ordinal_All(Social value) {
        Social result = Social.fromString(String.valueOf(value.ordinal()));
        assertEquals(value, result);
    }

    @ParameterizedTest
    @EnumSource(value = Social.class)
    void testGetLabel_notInvalid(Social status) {
        String label = status.getLabel();
        assertTrue(isResourceKeyValid(label));
    }

    static Stream<Arguments> provideSocialsAndIndices() {
        return Arrays.stream(Social.values())
                     .flatMap(trait -> IntStream.range(0, Social.MAXIMUM_VARIATIONS)
                                             .mapToObj(i -> Arguments.of(trait, i)));
    }

    @ParameterizedTest
    @MethodSource(value = "provideSocialsAndIndices")
    void testGetDescription_notInvalid(Social trait, int i) {
        String description = trait.getDescription(i, Gender.MALE, "Barry");
        assertTrue(isResourceKeyValid(description));
    }

    @ParameterizedTest
    @CsvSource(value = { "99", "1000", "-1" })
    void testGetDescription_InvalidDescriptionIndex(int invalidIndex) {
        String description = Social.NONE.getDescription(invalidIndex, Gender.MALE, "Barry");
        assertTrue(isResourceKeyValid(description));
    }

    @ParameterizedTest
    @EnumSource(value = Social.class)
    void testGetRoninMessage_notInvalid(Social trait) {
        String description = trait.getRoninMessage("Commander");
        assertTrue(isResourceKeyValid(description));
    }
}
