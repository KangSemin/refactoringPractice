public class Seat {
	private final String name;
	private SeatStatus booked;

	public Seat(String name) {
		this.name = name;
		this.booked = SeatStatus.AVAILABLE;
	}

	public String getName() {
		return name;
	}

	public boolean isBooked() {
		return booked == SeatStatus.BOOKED ;
	}

	public void book() {
		if (isBooked()) {
			throw new IllegalStateException("Seat " + name + " is already booked.");
		}
		this.booked = SeatStatus.BOOKED;
	}


}
