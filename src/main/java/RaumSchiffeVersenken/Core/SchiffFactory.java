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
                @Override
                public void setLaenge() {
                }

                @Override
                public void setLebensPunkte() {
                }

                @Override
                public int getxKoordinaten() {
                    return 0;
                }

                @Override
                public void setxKoordinaten() {
                }

                @Override
                public int getyKoordinaten() {
                    return 0;
                }

                @Override
                public void setyKoordinaten() {
                }

                @Override
                public void zielenZumSchiffeSetzen() {
                }

                @Override
                public void schiffSetzen() {
                }
            };
        } else if (kriterium.equals("2")) {
            return new Fregatte() {
                @Override
                public void setLaenge() {
                }

                @Override
                public void setLebensPunkte() {
                }

                @Override
                public int getxKoordinaten() {
                    return 0;
                }

                @Override
                public void setxKoordinaten() {
                }

                @Override
                public int getyKoordinaten() {
                    return 0;
                }

                @Override
                public void setyKoordinaten() {
                }

                @Override
                public void zielenZumSchiffeSetzen() {
                }

                @Override
                public void schiffSetzen() {
                }
            };
        } else if (kriterium.equals("4")) {
            return new Zerstoerer() {
                @Override
                public void setLaenge() {
                }

                @Override
                public void setLebensPunkte() {
                }

                @Override
                public int getxKoordinaten() {
                    return 0;
                }

                @Override
                public void setxKoordinaten() {
                }

                @Override
                public int getyKoordinaten() {
                    return 0;
                }

                @Override
                public void setyKoordinaten() {
                }

                @Override
                public void zielenZumSchiffeSetzen() {
                }

                @Override
                public void schiffSetzen() {
                }
            };
        } else if (kriterium.equals("5")) {
            return new Kreuzer() {
                @Override
                public void setLaenge() {
                }

                @Override
                public void setLebensPunkte() {
                }

                @Override
                public int getxKoordinaten() {
                    return 0;
                }

                @Override
                public void setxKoordinaten() {
                }

                @Override
                public int getyKoordinaten() {
                    return 0;
                }

                @Override
                public void setyKoordinaten() {
                }

                @Override
                public void zielenZumSchiffeSetzen() {
                }

                @Override
                public void schiffSetzen() {
                }
            };
        }

        return null;
    }

}
