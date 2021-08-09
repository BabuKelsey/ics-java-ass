import java.util.Scanner;

public class Qn3Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int iDotCount = 0, iSportCount = 0;
        char cGender = ' ';
        double dHRrest = 0.0, dHRmax = 0.0, dAge = 0.0, dVOmax = 0.0;
        String sInput = " "; //sGender = " ";
        Boolean bIsNum = true, bIsChar = true, bHasInput = false;

        System.out.print("Enter your heart rate at rest > ");
        sInput = input.nextLine();

        LABELtestForNum: while (!bHasInput) {
            LABELinner: while (bIsNum) {
                for (int i = 0; i < sInput.length(); i++) {
                    Boolean bFlag = Character.isDigit(sInput.charAt(i));
                    if (bFlag) {
                        bIsNum = true;
                    } else if (sInput.charAt(i) == '.') {
                        iDotCount++;

                        if (i == 0) {
                            break LABELinner;
                        } else if (iDotCount > 1) {
                            break LABELinner;
                        } else {
                            bIsNum = true;
                        }
                    } else {
                        bIsNum = false;
                        break LABELinner;
                    }
                }

                iDotCount = 0;

                dHRrest = Double.parseDouble(sInput);

                if (dHRrest < 35) {
                    System.out.print("Are you dead?\n");
                    break LABELinner;
                } else {
                    break LABELtestForNum;
                }
            }

            System.out.print("Please enter a valid heart rate that is more than 35 > ");
            sInput = input.nextLine();
            bIsNum = true;
            iDotCount = 0;
        }

        // System.out.println("> " + dHRrest); // test check print out

        System.out.print("Enter your age > ");
        sInput = input.nextLine();

        LABELtestForNum: while (!bHasInput) {
            LABELinner: while (bIsNum) {
                for (int i = 0; i < sInput.length(); i++) {
                    Boolean bFlag = Character.isDigit(sInput.charAt(i));
                    if (bFlag) {
                        bIsNum = true;
                    } else if (sInput.charAt(i) == '.') {
                        iDotCount++;

                        if (i == 0) {
                            break LABELinner;
                        } else if (iDotCount > 1) {
                            break LABELinner;
                        } else {
                            bIsNum = true;
                        }
                    } else {
                        bIsNum = false;
                        break LABELinner;
                    }
                }

                iDotCount = 0;
                
                dAge = Double.parseDouble(sInput);

                //break LABELtestForNum;

                if (dAge < 4) {
                    System.out.print("Please enter a real age.\n");
                    break LABELinner;
                } else {
                    break LABELtestForNum;
                }
            }

            System.out.print("Please enter a valid age that is more than 3 > ");
            sInput = input.nextLine();
            bIsNum = true;
            iDotCount = 0;
        }

        // System.out.println("> " + dAge); // test check print out

        System.out.print("Enter your gender [m/f] > ");
        sInput = input.nextLine();

        LABELtestForChar: while (!bHasInput) {
            LABELinner: while (bIsChar) {
                if (sInput.length() > 1) {
                    bIsChar = false;
                    break LABELinner;
                } else {
                    cGender = sInput.charAt(0);
                    bIsChar = true;

                    if (cGender == 'm' || cGender == 'M') {
                        cGender = 'M';
                        break LABELtestForChar;
                    } else if (cGender == 'f' || cGender == 'F') {
                        cGender = 'F';
                        break LABELtestForChar;
                    } else {
                        break LABELinner;
                    }
                }

                // if (sInput == "male" || sInput == "Male" || sInput == "m" || sInput == "M") {
                //     sGender = "M";
                //     break LABELtestForChar;
                // } else if (sInput == "female" || sInput == "Female" || sInput == "f" || sInput == "F") {
                //     sGender = "M";
                //     break LABELtestForChar;
                // } else {
                //     break LABELinner;
                // }
            }
            
            System.out.print("Please enter a valid gender [m/f] > ");
            sInput = input.nextLine();
            bIsChar = true;
        }

        dHRmax = 220 - dAge;
        dVOmax = 15 * (dHRmax / dHRrest);

        System.out.println("VO2Max > " + dVOmax); // test check print out

        if (dAge < 10) {
            System.out.print("You're too young to take part in any sport.\n");
        } else if (dAge > 30) {
            System.out.print("You're too old to take part in any sport.\n");
        }

        if (dAge >= 18 && dAge <= 30) {
            if (cGender == 'M' && (dVOmax >= 40 && dVOmax <= 60)) {
                iSportCount++;
                System.out.print("   Mens Basketball\n");
            } else if (cGender == 'F' && (dVOmax >= 43 && dVOmax <= 60)) {
                iSportCount++;
                System.out.print("   Womens Basketball\n");
            }
        }

        if (dAge >= 18 && dAge <= 26) {
            if (cGender == 'M' && (dVOmax >= 62 && dVOmax <= 74)) {
                iSportCount++;
                System.out.print("   Mens Cycling\n");
            } else if (cGender == 'F' && (dVOmax >= 47 && dVOmax <= 57)) {
                iSportCount++;
                System.out.print("   Womens Cycling\n");
            }

            if (cGender == 'M' && (dVOmax >= 55 && dVOmax <= 67)) {
                iSportCount++;
                System.out.print("   Mens Canoeing\n");
            } else if (cGender == 'F' && (dVOmax >= 47 && dVOmax <= 67)) {
                iSportCount++;
                System.out.print("   Womens Canoeing\n");
            }
        }

        if (dAge >= 18 && dAge <= 22) {
            if (cGender == 'M' && (dVOmax >= 52 && dVOmax <= 58)) {
                iSportCount++;
                System.out.print("   Mens Gymnastics\n");
            } else if (cGender == 'F' && (dVOmax >= 36 && dVOmax <= 50)) {
                iSportCount++;
                System.out.print("   Womens Gymnastics\n");
            }
        }

        if (dAge >= 10 && dAge <= 25) {
            if (cGender == 'M' && (dVOmax >= 50 && dVOmax <= 70)) {
                iSportCount++;
                System.out.print("   Mens Swimming\n");
            } else if (cGender == 'F' && (dVOmax >= 40 && dVOmax <= 60)) {
                iSportCount++;
                System.out.print("   Womens Swimming\n");
            }
        }

        if (iSportCount == 0) {
            System.out.print("You do not qualify for any type of sport.\n");
        } else if (iSportCount == 1) {
            System.out.printf("You qualify for 1 sport.\n");
        } else if (iSportCount > 0) {
            System.out.printf("You qualify for %d sports.\n", iSportCount);
        }
    }
}