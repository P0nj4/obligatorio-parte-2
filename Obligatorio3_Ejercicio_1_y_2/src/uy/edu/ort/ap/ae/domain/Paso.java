package uy.edu.ort.ap.ae.domain;

public class Paso {
	int ejeY;
	int ejeX;
	
	public Paso(){
		this.ejeX = -1;
		this.ejeY= -1;
	}
	public Paso(int x, int y){
		this.ejeX = x;
		this.ejeY= y;
	}
	public int getEjeY() {
		return ejeY;
	}
	public void setEjeY(int ejeY) {
		this.ejeY = ejeY;
	}
	public int getEjeX() {
		return ejeX;
	}
	public void setEjeX(int ejeX) {
		this.ejeX = ejeX;
	}
	
	public boolean equals(Paso p){
		if(p.ejeX == this.ejeX && this.ejeY == p.ejeY)return true;
		else return false;
	}
	
}
