import java.util.Scanner;

public class Qn1Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int iDotCount = 0;
        String sInput = " ";
        double dHeight = 0.0, dWeight = 0.0, dBMI = 0.0;
        Boolean bIsNum = true, bHasInput = false;

        System.out.print("Enter your height in meters > ");
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

                dHeight = Double.parseDouble(sInput);

                if (dHeight < 0.5) {
                    // System.out.print("Are you dead?\n");
                    break LABELinner;
                } else {
                    break LABELtestForNum;
                }
            }

            System.out.print("Please enter a valid height in meters and more than 0.5m > ");
            sInput = input.nextLine();
            bIsNum = true;
            iDotCount = 0;
        }

        // System.out.println("> " + dHeight); // test check print out

        System.out.print("Enter your weight in kilograms > ");
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

                dWeight = Double.parseDouble(sInput);

                if (dWeight < 10) {
                    // System.out.print("Are you dead?\n");
                    break LABELinner;
                } else {
                    break LABELtestForNum;
                }
            }

            System.out.print("Please enter a valid weight in KG and more than 10kg > ");
            sInput = input.nextLine();
            bIsNum = true;
            iDotCount = 0;
        }

        // System.out.println("> " + dWeight); // test check print out

        dBMI = dWeight / (dHeight * dHeight);

        if (dBMI <= 24) {
            System.out.printf("Your BMI is %.2f, and your status is: Under weight.\n", dBMI);
        } else if (dBMI > 24 && dBMI <= 29) {
            System.out.printf("Your BMI is %.2f, and your status is: Healthy.\n", dBMI);
        } else if (dBMI > 29 && dBMI <= 34) {
            System.out.printf("Your BMI is %.2f, and your status is: Over weight.\n", dBMI);
        } else if (dBMI > 34) {
            System.out.printf("Your BMI is %.2f, and your status is: Obese and thicc.\n", dBMI);
        }

        // =======================================

        // double dHeight, dWeight, dBMI;

        // System.out.print("Enter your height in meters > ");
        // dHeight = input.nextDouble();
        // // check for NaN and invalid inputs
        // if (dHeight <= 0) {
        // System.out.print("Please enter a valid height!\n");
        // return;
        // }

        // System.out.print("Enter your weight in kilograms > ");
        // dWeight = input.nextDouble();
        // // check for NaN and invalid inputs
        // if (dWeight <= 0) {
        // System.out.print("Please enter a valid weight!\n");
        // return;
        // }

        // dBMI = dWeight / (dHeight * dHeight);

        // if (dBMI <= 24) {
        // System.out.printf("Your BMI is %.2f, and your status is: Under weight.\n",
        // dBMI);
        // } else if (dBMI > 24 && dBMI <= 29) {
        // System.out.printf("Your BMI is %.2f, and your status is: Healthy.\n", dBMI);
        // } else if (dBMI > 29 && dBMI <= 34) {
        // System.out.printf("Your BMI is %.2f, and your status is: Over weight.\n",
        // dBMI);
        // } else if (dBMI > 34) {
        // System.out.printf("Your BMI is %.2f, and your status is: Obese and thicc.\n",
        // dBMI);
        // }

    }
}