import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		// 초기 좌석 리스트 생성
		List<Seat> seats = createSeats();
		//예약 요청 리스트
		List<String> bookingRequests = List.of("A2", "A3", "A1", "A4", "A6", "A3", "A8", "A7", "A5");

		// BookingManager로 예약 처리
		BookingManager bookingManager = new BookingManager(seats);
		bookingManager.bookRequests(bookingRequests);

		// 총 예약된 좌석 수 출력
		System.out.println("Total booked seats: " + bookingManager.countBookedSeats());
	}

	private static List<Seat> createSeats()
	{
		return new ArrayList<>(List.of(
				new Seat("A1"),
				new Seat("A2"),
				new Seat("A3"),
				new Seat("A4"),
				new Seat("A5"),
				new Seat("A6"),
				new Seat("A7"),
				new Seat("A8")
		));
	}
}
