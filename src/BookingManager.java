import java.util.List;
import java.util.Optional;

public class BookingManager {

	private final List<Seat> seats;

	public BookingManager(List<Seat> seats) {
		this.seats = seats;
	}

	public void processBookingRequests(List<String> bookingRequests) {

		//bookingRequests.forEach(this::attemptToBookSeat);
		bookingRequests.forEach(x-> findSeatByName(x).ifPresentOrElse(
				this::bookSeat,
				() -> System.out.println("Seat " + x + " does not exist.")
		));

	}

	public long countBookedSeats() {
		return seats.stream().filter(Seat::isBooked).count();
	}

	private Optional<Seat> findSeatByName(String name) {
		return seats.stream()
				.filter(seat -> seat.getName().equals(name))
				.findFirst();
	}

	private void bookSeat(Seat seat) {
		try {
			seat.book();
			System.out.println("Seat " + seat.getName() + " has been successfully booked.");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}


//	private void attemptToBookSeat(String request) {
//		findSeatByName(request)
//				.ifPresentOrElse(
//						this::bookSeat,
//						() -> System.out.println("Seat " + request + " does not exist.")
//				);
//	}

}
