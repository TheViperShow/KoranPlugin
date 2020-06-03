/*
 * KoranPlugin - A Minecraft plugin to interact with the Koran
 * Copyright (C) 2020 TheViperShow
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.thevipershow.koranplugin.structure;

import java.util.Arrays;
import java.util.List;

public class Surah implements WordCounter {
    private final List<Aja> aja;

    public Surah(List<Aja> ajaList) {
        this.aja = ajaList;
    }

    public Surah(Aja... ajat) {
        this.aja = Arrays.asList(ajat);
    }

    public List<Aja> getAja() {
        return aja;
    }

    @Override
    public int countOccurrences(String word) {
        return aja.parallelStream()
                .mapToInt(aja -> aja.countOccurrences(word))
                .sum();
    }
}
