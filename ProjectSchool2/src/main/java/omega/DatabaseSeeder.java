package omega;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner{
	
	private BookingRepository bookingRepository;
	
	@Autowired
	public DatabaseSeeder(BookingRepository bookingRepository) {
		this.bookingRepository=bookingRepository;
	}
	
	
	
	@Override
	public void run(String...strings) throws Exception {
     List<HotelBooking>bookings=new ArrayList<>();
		
		bookings.add(new HotelBooking("Yaki",250.6,3));
		bookings.add(new HotelBooking("Ibis",90.2,1));
		bookings.add(new HotelBooking("Novotel",140.9,3));	
		bookings.add(new HotelBooking("Minerva",250.6,3));
		bookings.add(new HotelBooking("Royal",90.2,1));
		bookings.add(new HotelBooking("Not",140.9,3));	
		
		bookingRepository.saveAll(bookings);
	}

}
