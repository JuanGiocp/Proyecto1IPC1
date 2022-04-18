package project1.sap.store;

import project1.sap.store.pets.Pet;
import project1.sap.store.pets.Pets;
import project1.sap.util.Util;

import java.util.Arrays;

public class Store {
    private static Pet[] product;
    private Pet[] user;
    private Pet[] bot;
    public static int costInit = 10;
    public static int costInitBot = 10;

    public Store() {
    }

    public Pet[] getUser() {
        return user;
    }

    public void setUser(Pet[] user) {
        this.user = user;
    }

    public Pet[] getBot() {
        return bot;
    }

    public void setBot(Pet[] bot) {
        this.bot = bot;
    }

    public Pet buyPets(int rd) {
        Pet init = null;
        if (rd >= 0) {
            if (init == null) {
                if (costInit > 2) {
                    init = product[Util.requestNumber("Select pet",1,8)-1];
                    costInit = costInit - 3;
                }
            }
        }
        System.out.println(" ");
        return init;
    }

    public Pet buyPetsBot(int rd) {
        Pet init1 = null;
        int nRandom = Util.generateRandomNumber(1, 8) - 1;
        if (rd >= 0) {
            if (init1 == null) {
                if (costInitBot > 2) {
                    init1 = product[nRandom];
                    costInitBot = costInitBot - 3;
                }
            }
        }
        System.out.println(" ");
        return init1;
    }

    public Pet[] mergePetsUser() {
        // Get the array
        Pet[] arr = new Pet[5];
        System.arraycopy(arr, 0, this.user, 0, arr.length);
        // Print the resultant array
        System.out.println("Original Array: ");
        Arrays.stream(arr).forEach(System.out::println);
        // Get the specific index
        int index = Util.requestNumber("insert the pet you want to sell", 1, 6) - 1;
        // Print the index
        System.out.println("Index to be removed: " + index);
        // Remove the element
        arr =  Util.removeTheElement(arr, index);
        // Print the resultant array
        System.out.println("Resultant Array:");
        Arrays.stream(arr).forEach(System.out::println);
        costInit = costInit + 3;

        return new Pet[]{arr[0]};
    }

    public void viewPet(int rd) {
        Pet[] view = new Pet[54];
        product = view;

        int i;
        for (i = 0; i < Pets.tier1.length; i++) {
            view[i] = Pets.tier1[i];
        }
        int j;
        for (j = 0; j < Pets.tier2.length; j++) {
            view[i + j] = Pets.tier2[j];
        }
        int k;
        for (k = 0; k < Pets.tier3.length; k++) {
            view[i + j + k] = Pets.tier3[k];
        }
        int l;
        for (l = 0; l < Pets.tier4.length; l++) {
            view[i + j + k + l] = Pets.tier4[l];
        }
        int m;
        for (m = 0; m < Pets.tier5.length; m++) {
            view[i + j + k + l + m] = Pets.tier5[m];
        }
        int n;
        for (n = 0; n < Pets.tier6.length; n++) {
            view[i + j + k + l + m + n] = Pets.tier6[n];
        }
        int o;
        for (o = 0; o < Pets.tier7.length; o++) {
            view[i + j + k + l + m + n + o] = Pets.tier7[o];
        }

        Pet[] pets = product;
        if (rd == 1) {
            for (int i1 = 0; i1 < 8; i1++) {
                System.out.println((i1 + 1) + ".)" + pets[i1]);
            }
        } else if (rd == 2 || rd == 3) {
            for (int j1 = 0; j1 < 16; j1++) {
                System.out.println((j1 + 1) + ".)" + pets[j1]);
            }
        } else if (rd == 4 || rd == 5) {
            for (int k1 = 0; k1 < 27; k1++) {
                System.out.println((k1 + 1) + ".)" + pets[k1]);
            }
        } else if (rd == 6 || rd == 7) {
            for (int l1 = 0; l1 < 35; l1++) {
                System.out.println((l1 + 1) + ".)" + pets[l1]);
            }
        } else if (rd == 8 || rd == 9) {
            for (int m1 = 0; m1 < 43; m1++) {
                System.out.println((m1 + 1) + ".)" + pets[m1]);
            }
        } else if (rd == 10 || rd == 11) {
            for (int n1 = 0; n1 < 52; n1++) {
                System.out.println((n1 + 1) + ".)" + pets[n1]);
            }
        } else if (rd == 12) {
            for (int o1 = 0; o1 < 54; o1++) {
                System.out.println((o1 + 1) + ".)" + pets[o1]);
            }
        }
    }
}