import java.util.Scanner;
import java.io.*;

class maxTime {
	char number[] = new char[9];
	char time[] = new char[8];
	int occ[] = new int[10];
	int i, j, temp;
	void maxCount(int num) {
		for(j = 0; j < num; j++) {
			if(occ[j] != 0) {
				temp = j;
			}
		}		
	}
	char itoc(int num) {
		switch(num) {
			case 0:
				return '0';
			case 1:
				return '1';
			case 2: 
				return '2';
                        case 3:
                                return '3';
                        case 4:
                                return '4';
                        case 5:
                                return '5';
                        case 6:
                                return '6';
                        case 7:
                                return '7';
                        case 8:
                                return '8';
                        case 9:
                                return '9';
			default:
				return '!';
		}
	}
	void inputNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		for(i = 0; i < 9; i++) {
			sc.useDelimiter("");
			number[i] = sc.next().charAt(0);
		}
	}
	void setMaxTime() {
                for(i = 0; i < 10; i++) {
                        occ[i] = 0;
                }
                for(i = 0; i < 9; i++) {
                        occ[number[i] - '0']++;
                }
                time[2] = ':';
                time[5] = ':';
                if(occ[1] >= 1 && occ[2] >= 1 && occ[0] >= 4) {
                        time[0] = '1';
                        time[1] = '2';
                        time[3] = time[4] = time[6] = time[7] = '0';
                        getMaxTime();
                }
                else if(occ[1] >= 1 && occ[0] >= 0) {
                        time[0] = '1';
                        occ[1] -= 1;
			if(occ[1] == 0 && occ[0] == 0) {
				System.out.println("Not possible to form 12 hour clock");
			}
			else {
				for(i = 1; i < 8; i++) {
					if(i == 2 || i == 5) {
						time[i] = ':';
					}
					else if(i == 1) {
						maxCount(2);
						time[i] = itoc(temp);
						occ[temp] -= 1;
					}
					else if(i == 4 || i == 7) {
						maxCount(10);
						time[i] = itoc(temp);
						occ[temp] -= 1;
					}
					else if(i == 3 || i == 6) {
						maxCount(6);
						time[i] = itoc(temp);
						occ[temp] -= 1;
					}
				}
				getMaxTime();
			}
                }
                else if(occ[1] == 0 && occ[0] >= 1) {
                        time[0] = '0';
                        occ[0] -= 1;
                        for(i = 1; i < 8; i++) {
                                if(i == 2 || i == 5) {
                                        time[i] = ':';
                                }
                                else if(i == 1 || i == 4 || i == 7) {
                                        maxCount(10);
                                        time[i] = itoc(temp);
                                        occ[temp] -= 1;
                                }
                                else if(i == 3 || i == 6) {
                                        maxCount(6);
                                        time[i] = itoc(temp);
                                        occ[temp] -= 1;
                                }
                        }
                        getMaxTime();
                }
                else {
                        System.out.println("Not possible to form 12 hour clock");
                }	
	}
	void getMaxTime() {
		for(i = 0; i < 8; i++) {
			System.out.print(time[i]);
		}
		System.out.println();
	}
	public static void main(String args[]) {
		maxTime time = new maxTime();
		time.inputNumber();
		time.setMaxTime();
	}
};	
