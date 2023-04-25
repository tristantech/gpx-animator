/*
 *  Copyright Contributors to the GPX Animator project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package app.gpx_animator.core.data;

import app.gpx_animator.core.preferences.Preferences;

import javax.swing.JComboBox;
import java.util.Arrays;
import java.util.Locale;

public enum DistanceUnit {
    METERS("m", m -> m, "%.0f"),
    KILOMETERS("km", m -> m / 1000.0, "%.2f"),
    FEET("ft", m -> m * 3.28084, "%.0f"),
    MILES("mi", m -> m / 1609.34, "%.2f");

    private final String abbreviation;
    private final transient Calculation calculation;
    private final String formatString;

    public static void fillComboBox(final JComboBox<DistanceUnit> comboBox) {
        Arrays.stream(values()).forEach(comboBox::addItem);
    }

    /**
     * Define a speed unit.
     *
     * @param abbreviation the abbreviation of the speed unit
     * @param calculation how to calculate the speed, based on KMH
     */
    DistanceUnit(final String abbreviation, final Calculation calculation, final String formatString) {
        this.abbreviation = abbreviation;
        this.calculation = calculation;
        this.formatString = formatString;
    }

    @Override
    public String toString() {
        return Preferences.getResourceBundle()
                .getString("distanceunit.".concat(name().toLowerCase(Locale.getDefault())));
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Convert given distance and return formatted string based on the unit's `formatString`.
     * @param distance Input distance in meters
     * @return Formatted string
     */
    public String getFormatted(final double distance) {
        return formatString.formatted(convertDistance(distance));
    }

    public double convertDistance(final double distance) {
        return calculation.calc(distance);
    }

    public static DistanceUnit parse(final String unitString, final DistanceUnit defaultUnit) {
        return Arrays.stream(DistanceUnit.values())
                .filter(distanceUnit -> distanceUnit.name().equalsIgnoreCase(unitString)
                        || distanceUnit.getAbbreviation().equalsIgnoreCase(unitString))
                .findAny()
                .orElse(defaultUnit);
    }

}
