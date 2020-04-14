#include<stdio.h>
#include<string.h>

int maxcount(int arr[], int num);

char itoc(int num);

int main() {
	char digit[10], time[9];
	int occ[10];
	int i, temp;
	printf("Enter number: ");
	scanf("%s", digit);
	while(strlen(digit) != 9) {
		printf("Invalid input.\n");
		printf("Enter number: ");
		scanf("%s", digit);
	}
	for(i = 0; i < 10; i++) {
		occ[i] = 0;
	}
	for(i = 0; i < 9; i++) {
		occ[digit[i] - '0']++;
	}
	time[2] = ':';
	time[5] = ':';
	time[8] = '\0';
	if(occ[1] >= 1 && occ[2] >= 1 && occ[0] >= 4) {
		time[0] = '1';
		time[1] = '2';
		time[3] = time[4] = time[6] = time[7] = '0';
                printf("%s\n", time);
	}
        else if(occ[1] >= 1 && occ[0] >= 0) {
                time[0] = '1';
                occ[1] = occ[1] - 1;
                for(i = 0; i < 9; i++) {
                        if(i == 2 || i == 5) {
                                time[i] = ':';
                        }
                        else if(i == 8) {
                                time[i] = '\0';
                        }
			else if(i == 1){
				temp = maxcount(occ, 2);
				time[i] = itoc(temp);
				occ[temp] -= 1;
			}
                        else if(i == 4 || i == 7) {
                                temp = maxcount(occ, 10);
                                time[i] = itoc(temp);
				occ[temp] -= 1;
                        }
                        else if(i == 3 || i == 6) {
                                temp = maxcount(occ, 6);
                                time[i] = itoc(temp);
				occ[temp] -= 1;
                        }
		}
		printf("%s\n", time);
        }
        else if(occ[1] == 0 && occ[0] >= 1) {
                time[0] = '0';
                occ[0] = occ[0] - 1;
		for(i = 0; i < 9; i++) {
			if(i == 2 || i == 5) {
				time[i] = ':';
			}
			else if(i == 8) {
				time[i] = '\0';
			}
			else if(i == 1 || i == 4 || i == 7) {
				temp = maxcount(occ, 10);
				time[i] = itoc(temp);
				occ[temp] -= 1;
			}
			else if(i == 3 || i == 6) {
				temp = maxcount(occ, 6);
				time[i] = itoc(temp);
				occ[temp] -= 1;
			}
		}
		printf("%s\n", time);
	}
	else {
		printf("Cannot display max time\n");
	}					
	return 0;
}

int maxcount(int arr[], int num) {
	int i, temp;
        for(i = 0; i < num; i++) {
        	if(arr[i] != 0) {
                	temp = i;
        	}
	}
	return temp;
}

char itoc(int num) {
	return '0' + num; 
}
						
