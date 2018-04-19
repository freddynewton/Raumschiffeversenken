package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Core.SchiffsArten.Fregatte;
import RaumSchiffeVersenken.Core.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.Core.SchiffsArten.Kreuzer;
import RaumSchiffeVersenken.Core.SchiffsArten.Zerstoerer;
import RaumSchiffeVersenken.Interface.RaumSchiff;

public class SchiffFactory {

    public static RaumSchiff getRaumschiff(String kriterium) {

        if (kriterium.equals("1")) {
            return new Jaeger() {
            };

        } else if (kriterium.equals("2")) {
            return new Fregatte() {
            };

        } else if (kriterium.equals("4")) {
            return new Zerstoerer() {
            };

        } else if (kriterium.equals("5")) {
            return new Kreuzer() {
            };
        }

        return null;
    }

}
