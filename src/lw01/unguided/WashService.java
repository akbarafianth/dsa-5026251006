package lw01.unguided;
public abstract class WashService implements Billable {
    private String id;
	private int days;

	protected WashService(String id, int days) {
		if(days >= 30) {
			throw new IllegalArgumentException("hari harus kurang dari 30 hari");
		}
		this.id = id;
		this.days = days;
	}

	public String getId() {
		return this.id;
	}

	public int getDays() {
		return this.days;
	}

	@Override 
	public abstract int calculateCharge();

	public int calculateCharge(int units) {
		if(units >= 10) {
			throw new IllegalArgumentException("units tidak boleh lebih dari 10");
		}
		return this.calculateCharge() * units;
	}

	public String label() {
		return "Service";
	}

	public String summary() {
		return id + " | " + label() + " | " + calculateCharge() ;
    }
}
