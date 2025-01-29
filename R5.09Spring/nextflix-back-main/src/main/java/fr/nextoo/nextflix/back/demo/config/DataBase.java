package fr.nextoo.nextflix.back.demo.config;

public class DataBase {
	private int currentIdSession;
	private static final DataBase INSTANCE = new DataBase();

	private DataBase(){
	}

	public static DataBase getInstance() {
		return INSTANCE;
	}

	public int getCurrentIdSession() {
		return this.currentIdSession;
	}

	public void setCurrentIdSession(Integer newIdSession) {
		this.currentIdSession = newIdSession;
	}
}
