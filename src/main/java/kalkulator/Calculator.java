package kalkulator;

public class Calculator {
	private int state = 0;
	private int memory = 0;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void saveToMemory() {
		this.memory = this.state;
	}

	public void loadFromMemory() {
		if (this.memory != 0) {
			this.state = this.memory;
		} else {
			throw new IllegalStateException("Pamięć jest pusta");
		}
	}

	public void clearMemory() {
		this.memory = 0;
	}

	public void add(int value){
		long result = (long)this.state + (long)value;

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			throw new ArithmeticException("Przekroczenie zakresu INT!");
		} else {
			state += value;
		}

	}

	public void subtract(int value){
		long result = (long)this.state - (long)value;

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			throw new ArithmeticException("Przekroczenie zakresu INT!");
		} else {
			state -= value;
		}

	}

	public void mult(int value){
		long result = (long)state * (long)value;

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			throw new ArithmeticException("Przekroczenie zakresu INT!");
		} else {
			state *= value;
		}
	}

	public void power(int value){

		if(value == 0) {
			state = 1;
		} else if (value < 0) {
			throw new ArithmeticException("Nie obsługujemy liczb mniejszych od zera :)");
		} else {

			long result = state;
			int temp = state;
			for (int i = 1; i < value; i++) {
				result *= temp;

				if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
					throw new ArithmeticException("Przekroczenie zakresu INT!");
				} else {
					state *= temp;
				}
			}


		}
	}

}
