import java.util.Scanner;

public class Qn2Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double dLvl = 0.0, dLvlMin = 0.0, dLvlMax = 0.0, dLvlAvg = 0.0, dTotalLvl = 0.0;
        int iEntryCount = 0, iDotCount = 0;
        String sLvl;
        Boolean bIsNum = true, bHasInput = false;

        LABELrainLevel: while (dLvl >= 0) {
            System.out.print("Enter level > ");
            sLvl = input.nextLine();

            // NaN check
            LABELtestForNum: while (!bHasInput) {
                LABELinner: while (bIsNum) {
                    for (int i = 0; i < sLvl.length(); i++) {
                        Boolean bFlag = Character.isDigit(sLvl.charAt(i));
                        if (bFlag) {
                            bIsNum = true;
                        } else if (sLvl.charAt(i) == '.') {
                            // if its a '.' on i, check if the prev is '-' or '.', if true, break
                            iDotCount++;

                            if (i == 0) {
                                bIsNum = true;
                            } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.') {
                                break LABELinner;
                            } else if (iDotCount > 1) {
                                break LABELinner;
                            } else {
                                bIsNum = true;
                            }
                        } else if (sLvl.charAt(i) == '-') {
                            if (i == 0) {
                                bIsNum = true;
                            } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.'
                                    || (sLvl.charAt(i - 1) >= 48 && sLvl.charAt(i - 1) <= 57)) {
                                // if char at i-1 == '-' || '.'|| 0-9, when char == '-', break out
                                break LABELinner;
                            } else {
                                bIsNum = true;
                            }
                        } else if (sLvl.charAt(i) == ' ') {
                            bIsNum = false;
                            break LABELinner;
                        } else {
                            bIsNum = false;
                            break LABELinner;
                        }
                    }

                    iDotCount = 0;

                    dLvl = Double.parseDouble(sLvl);
                    break LABELtestForNum;
                }

                // at bIsNum == false, comes out here
                // prompt new input
                System.out.print("Please enter a number > ");
                sLvl = input.nextLine();
                bIsNum = true;
                iDotCount = 0;
            }

            if (iEntryCount == 0) {
                dLvlMin = dLvl;
                dLvlMax = dLvl;
            }

            if (dLvl < 0) {
                System.out.printf("==Terminated with %d entries==\n", iEntryCount);

                break LABELrainLevel;
            }

            iEntryCount++;
            dTotalLvl += dLvl;
            dLvlAvg = dTotalLvl / iEntryCount;

            if (dLvl < dLvlMin) {
                dLvlMin = dLvl;
            }
            if (dLvl > dLvlMax) {
                dLvlMax = dLvl;
            }

            System.out.printf(
                    "%d) Rainfall level = %.2f\n   Minimum level = %.2f\n   Maximum level = %.2f\n   Average level = %.2f\n",
                    iEntryCount, dLvl, dLvlMin, dLvlMax, dLvlAvg);

            if (dLvl == 0) {
                System.out.printf("==Ended with %d entries==\n", iEntryCount);
                break LABELrainLevel;
            }
        }
    }
}

// ===============================================================

// import java.util.Scanner;

// public class Qn2Test {
// public static void main(String[] args) {
// Scanner input = new Scanner(System.in);

// double dLvl = 1.0, dLvlMin = 0.0, dLvlMax = 0.0, dLvlAvg = 0.0, dTotalLvl =
// 0.0;
// int iEntryCount = 0, iDotCount = 0;
// String sLvl;
// Boolean bIsNum = true, bHasInput = false;

// // System.out.print("Enter level > ");
// // sLvl = input.nextLine();

// // NaN check
// // LABELtestForNum: while (!bHasInput) {
// // LABELinner: while (bIsNum) {
// // for (int i = 0; i < sLvl.length(); i++) {
// // Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// // if (bFlag) {
// // bIsNum = true;
// // } else if (sLvl.charAt(i) == '.') {
// // // if its a '.' on i, check if the prev is '-' or '.', if true, break
// // iDotCount++;

// // if (i == 0) {
// // bIsNum = true;
// // } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.') {
// // break LABELinner;
// // } else if (iDotCount > 1) {
// // break LABELinner;
// // } else {
// // bIsNum = true;
// // }
// // } else if (sLvl.charAt(i) == '-') {
// // if (i == 0) {
// // bIsNum = true;
// // } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.'
// // || (sLvl.charAt(i - 1) >= 48 && sLvl.charAt(i - 1) <= 57)) {
// // // if char at i-1 == '-' || '.'|| 0-9, when char == '-', break out
// // break LABELinner;
// // } else {
// // bIsNum = true;
// // }
// // } else if (sLvl.charAt(i) == ' ') {
// // bIsNum = false;
// // break LABELinner;
// // } else {
// // bIsNum = false;
// // break LABELinner;
// // }
// // }

// // iDotCount = 0;

// // dLvl = Double.parseDouble(sLvl);
// // break LABELtestForNum;
// // }

// // // at bIsNum == false, comes out here
// // // prompt new input
// // System.out.print("Please enter a number > ");
// // sLvl = input.nextLine();
// // bIsNum = true;
// // iDotCount = 0;
// // }

// // dLvlMin = dLvl;
// // dLvlMax = dLvl;

// LABELrainLevel: while (dLvl >= 0) {
// System.out.print("Enter level > ");
// sLvl = input.nextLine();

// // NaN check
// LABELtestForNum: while (!bHasInput) {
// LABELinner: while (bIsNum) {
// for (int i = 0; i < sLvl.length(); i++) {
// Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// if (bFlag) {
// bIsNum = true;
// } else if (sLvl.charAt(i) == '.') {
// // if its a '.' on i, check if the prev is '-' or '.', if true, break
// iDotCount++;

// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.') {
// break LABELinner;
// } else if (iDotCount > 1) {
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == '-') {
// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i - 1) == '-' || sLvl.charAt(i - 1) == '.'
// || (sLvl.charAt(i - 1) >= 48 && sLvl.charAt(i - 1) <= 57)) {
// // if char at i-1 == '-' || '.'|| 0-9, when char == '-', break out
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == ' ') {
// bIsNum = false;
// break LABELinner;
// } else {
// bIsNum = false;
// break LABELinner;
// }
// }

// iDotCount = 0;

// dLvl = Double.parseDouble(sLvl);
// break LABELtestForNum;
// }

// // at bIsNum == false, comes out here
// // prompt new input
// System.out.print("Please enter a number > ");
// sLvl = input.nextLine();
// bIsNum = true;
// iDotCount = 0;
// }

// if (iEntryCount == 0) {
// dLvlMin = dLvl;
// dLvlMax = dLvl;
// }

// if (dLvl < 0) {
// System.out.printf("==Terminated with %d entries==\n", iEntryCount);

// break LABELrainLevel;
// }

// iEntryCount++;
// dTotalLvl += dLvl;
// dLvlAvg = dTotalLvl / iEntryCount;

// if (dLvl < dLvlMin) {
// dLvlMin = dLvl;
// }
// if (dLvl > dLvlMax) {
// dLvlMax = dLvl;
// }

// System.out.printf(
// "%d) Rainfall level = %.2f\n Minimum level = %.2f\n Maximum level = %.2f\n
// Average level = %.2f\n",
// iEntryCount, dLvl, dLvlMin, dLvlMax, dLvlAvg);

// if (dLvl == 0) {
// System.out.printf("==Ended with %d entries==\n", iEntryCount);
// break LABELrainLevel;
// }

// // System.out.print("Enter level > ");
// // sLvl = input.nextLine();

// }
// }
// }

// ========================================================

// import java.util.Scanner;

// public class Qn2Test {
// public static void main(String[] args) {
// Scanner input = new Scanner(System.in);

// double dLvl = 0, dLvlMin, dLvlMax, dLvlAvg, dTotalLvl = 0;
// int iEntryCount = 0, iDotCount = 0;
// String sLvl;
// Boolean bIsNum = true, bHasInput = false;

// System.out.print("Enter level > ");
// sLvl = input.nextLine();

// // NaN check
// LABELtestForNum: while (!bHasInput) {
// LABELinner: while (bIsNum) {
// for (int i = 0; i < sLvl.length(); i++) {
// Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// if (bFlag) {
// bIsNum = true;
// } else if (sLvl.charAt(i) == '.') {
// // if its a '.' on i, check if the prev is '-' or '.', if true, break
// // write a check for bHasDot
// iDotCount++;

// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i-1) == '-' || sLvl.charAt(i-1) == '.') {
// break LABELinner;
// } else if (iDotCount > 1) {
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == '-') {
// // only input that doesnt get properly get checked is '-.' or '.-'
// // if its a '-' on i, check if the prev is '-' or '.', if true, break

// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i-1) == '-' || sLvl.charAt(i-1) == '.' ||
// (sLvl.charAt(i-1) >= 48 && sLvl.charAt(i-1) <= 57)) {
// // if char at i-1 == '-' || '.'|| 0-9, when char == '-', break out
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == ' '){
// bIsNum = false;
// break LABELinner;
// } else {
// bIsNum = false;
// break LABELinner;
// }
// }

// iDotCount = 0;

// dLvl = Double.parseDouble(sLvl);
// break LABELtestForNum;
// }

// // at bIsNum == false, comes out here
// // prompt new input
// System.out.print("Please enter a number > ");
// sLvl = input.nextLine();
// bIsNum = true;
// iDotCount = 0;
// }

// dLvlMin = dLvl;
// dLvlMax = dLvl;

// LABELrainLevel: while (dLvl >= 0) {
// // NaN check
// LABELtestForNum: while (!bHasInput) {
// LABELinner: while (bIsNum) {
// for (int i = 0; i < sLvl.length(); i++) {
// Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// if (bFlag) {
// bIsNum = true;
// } else if (sLvl.charAt(i) == '.') {
// // if its a '.' on i, check if the prev is '-' or '.', if true, break
// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i-1) == '-' || sLvl.charAt(i-1) == '.') {
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == '-') {
// // if its a '.' on i, check if the prev is '-' or '.', if true, break
// // write a check for bHasDot
// iDotCount++;

// if (i == 0) {
// bIsNum = true;
// } else if (sLvl.charAt(i-1) == '-' || sLvl.charAt(i-1) == '.') {
// break LABELinner;
// } else if (iDotCount > 1) {
// break LABELinner;
// } else {
// bIsNum = true;
// }
// } else if (sLvl.charAt(i) == ' '){
// bIsNum = false;
// break LABELinner;
// } else {
// bIsNum = false;
// break LABELinner;
// }
// }

// iDotCount = 0;

// dLvl = Double.parseDouble(sLvl);
// break LABELtestForNum;
// }

// // at bIsNum == false, comes out here
// // prompt new input
// System.out.print("Please enter a number > ");
// sLvl = input.nextLine();
// bIsNum = true;
// iDotCount = 0;
// }

// if (dLvl < 0) {
// System.out.printf("==Terminated with %d entries==\n", iEntryCount);

// break LABELrainLevel;
// }

// iEntryCount++;
// dTotalLvl += dLvl;
// dLvlAvg = dTotalLvl / iEntryCount;

// if (dLvl < dLvlMin) {
// dLvlMin = dLvl;
// }
// if (dLvl > dLvlMax) {
// dLvlMax = dLvl;
// }

// System.out.printf(
// "%d) Rainfall level = %.2f\n Minimum level = %.2f\n Maximum level = %.2f\n
// Average level = %.2f\n",
// iEntryCount, dLvl, dLvlMin, dLvlMax, dLvlAvg);

// if (dLvl == 0) {
// System.out.printf("==Ended with %d entries==\n", iEntryCount);
// break LABELrainLevel;
// }

// System.out.print("Enter level > ");
// sLvl = input.nextLine();

// }
// }
// }

// ==================================

// import java.util.Scanner;

// public class Qn2Test {
// public static void main(String[] args) {
// Scanner input = new Scanner(System.in);

// double dLvl = 0, dLvlMin, dLvlMax, dLvlAvg, dTotalLvl = 0;
// int iCount = 0;
// String sLvl;
// Boolean bIsNum = true, bHasInput = false;

// System.out.print("Enter level > ");
// sLvl = input.next();
// // dLvl = input.nextDouble();

// LABELtestForNum: while (!bHasInput) {
// LABELinner: while (bIsNum) {
// for (int i = 0; i < sLvl.length(); i++) {
// Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// if (bFlag) {
// System.out.print("'" + sLvl.charAt(i) + "' is a number\n");
// bIsNum = true;
// } else if (sLvl.charAt(i) == '.') {
// System.out.print("'" + sLvl.charAt(i) + "' is a number\n");
// bIsNum = true;
// } else {
// System.out.print("'" + sLvl.charAt(i) + "' is a letter\nPlease enter a number
// > ");
// bIsNum = false;
// break LABELinner;
// }
// }
// dLvl = Double.parseDouble(sLvl);
// break LABELtestForNum;
// }
// // at bIsNum == false, comes out here
// // prompt new input
// // System.out.print("Please enter a number > ");
// sLvl = input.next();
// bIsNum = true;
// }

// dLvlMin = dLvl;
// dLvlMax = dLvl;

// LABELrainLevel: while (dLvl > 0) {
// // NaN check
// LABELtestForNum: while (!bHasInput) {
// LABELinner: while (bIsNum) {
// for (int i = 0; i < sLvl.length(); i++) {
// Boolean bFlag = Character.isDigit(sLvl.charAt(i));
// if (bFlag) {
// System.out.print("'" + sLvl.charAt(i) + "' is a number\n");
// bIsNum = true;
// } else if (sLvl.charAt(i) == '.') {
// System.out.print("'" + sLvl.charAt(i) + "' is a number\n");
// bIsNum = true;
// } else {
// System.out.print("'" + sLvl.charAt(i) + "' is a letter\nPlease enter a number
// > ");
// bIsNum = false;
// break LABELinner;
// }
// }
// dLvl = Double.parseDouble(sLvl);
// break LABELtestForNum;
// }
// // at bIsNum == false, comes out here
// // prompt new input
// System.out.print("Please enter a number > ");
// sLvl = input.next();
// bIsNum = true;
// }

// iCount++;
// dTotalLvl += dLvl;
// dLvlAvg = dTotalLvl / iCount;

// if (dLvl < dLvlMin) {
// dLvlMin = dLvl;
// }
// if (dLvl > dLvlMax) {
// dLvlMax = dLvl;
// }

// System.out.printf(
// "%d) Rainfall level = %.2f\nMinimum level = %.2f\nMaximum level =
// %.2f\nAverage level = %.2f\n",
// iCount, dLvl, dLvlMin, dLvlMax, dLvlAvg);

// if (dLvl == 0) {
// iCount++;
// dTotalLvl += dLvl;
// dLvlAvg = dTotalLvl / iCount;
// dLvlMin = 0;

// // System.out.printf(
// // "%d) Rainfall level = %.2f\nMinimum level = %.2f\nMaximum level =
// %.2f\nAverage level = %.2f\n==Ended with %d entries==\n",
// // iCount, dLvl, dLvlMin, dLvlMax, dLvlAvg, iCount);

// break LABELrainLevel;
// } else if (dLvl < 0) {
// System.out.printf("==Terminated with %d entries==\n", iCount);

// break LABELrainLevel;
// }

// System.out.print("Enter level > ");
// // dLvl = input.nextDouble();
// sLvl = input.next();

// }

// // if (dLvl == 0) {
// // iCount++;
// // dTotalLvl += dLvl;
// // dLvlAvg = dTotalLvl / iCount;
// // dLvlMin = 0;

// // System.out.printf(
// // "%d) Rainfall level = %.2f\nMinimum level = %.2f\nMaximum level =
// %.2f\nAverage level = %.2f\n==Ended with %d entries==\n",
// // iCount, dLvl, dLvlMin, dLvlMax, dLvlAvg, iCount);
// // } else if (dLvl < 0) {
// // System.out.printf("==Terminated with %d entries==\n", iCount);
// // }
// }
// }
