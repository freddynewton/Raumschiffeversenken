package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Core.SchiffsArten.Bomber;
import RaumSchiffeVersenken.Core.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.Core.SchiffsArten.Zerstoerer;
import RaumSchiffeVersenken.Core.SchiffsArten.Fregatte;
import RaumSchiffeVersenken.Interface.RaumSchiff;

public class SchiffFactory {

    /**
     * @param kriterium
     * @return je nach Kriterium ein Schiff
     */
    public static RaumSchiff getRaumschiff(String kriterium) {


        if (kriterium.equals("1")) {
            return new Jaeger() {
            };

        } else if (kriterium.equals("2")) {
            return new Bomber() {
            };

        } else if (kriterium.equals("4")) {
            return new Fregatte() {
            };

        } else if (kriterium.equals("5")) {
            return new Zerstoerer() {
            };
        }

        return null;
    }

}
