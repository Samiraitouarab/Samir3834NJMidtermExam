package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class LowestNumber {

	public static void main(String[] args) {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.
		 */
		int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
        int size = array.length;
		for(int i = 0; i<size; i++ ){
			for(int j = i+1; j<size; j++){
				if(array[i]>array[j]){
				  int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("Smallest element of the array is: "+array[0]);



		//find lowest number from the array

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		List<String> lowestValue = new ArrayList<String>();
		try {
			connectToSqlDB.insertDataFromArrayToSqlTable(array, "lowerNumber","lowest");

			lowestValue = connectToSqlDB.readDataBase("lowestNumber", "lowest");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data is reading from the Table (tbl_lowestNumber) and displaying to the console");
		for(String st:lowestValue){
			System.out.println(st);
		}
	}

}
