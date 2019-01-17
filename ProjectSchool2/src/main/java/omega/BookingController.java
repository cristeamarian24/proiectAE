package omega;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/bookings")
@Api(name="Tourism API",description="List of methods for bookings",stage=ApiStage.RC)
public class BookingController {
	//private List<HotelBooking>bookings;
	
	private BookingRepository bookingRepository;
	
	@Autowired
	public BookingController(BookingRepository bookingRepository) {
		this.bookingRepository=bookingRepository;
		/*
		bookings=new ArrayList<>();
		
		bookings.add(new HotelBooking("Yaki",250.6,3));
		bookings.add(new HotelBooking("Ibis",90.2,1));
		bookings.add(new HotelBooking("Novotel",140.9,3));	
		bookings.add(new HotelBooking("Minerva",250.6,3));
		bookings.add(new HotelBooking("Royal",90.2,1));
		bookings.add(new HotelBooking("Not",140.9,3));	
		*/
		
		
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ApiMethod(description="Get all bookings from db")
	public List<HotelBooking>getAll() {
		//return bookings;
		return bookingRepository.findAll();
	}
	
	@RequestMapping(value="/affordable/{price}",method=RequestMethod.GET)
	@ApiMethod(description="Get all hotel under a certain threshhold")
	public List<HotelBooking>getAffordable(@ApiPathParam(name="price")@PathVariable double price) {
	//	return bookings.stream().filter(x->x.getPricePerNight() <= price).collect(Collectors.toList());
		return bookingRepository.findByPricePerNightLessThan(price);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ApiMethod(description="Create hotel booking")
	public List<HotelBooking>create(@RequestBody HotelBooking hotelBooking) {
		//bookings.add(hotelBooking);
		//return bookings;
		
		bookingRepository.save(hotelBooking);
		return bookingRepository.findAll();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ApiMethod(description="Remove booking")
	public List<HotelBooking>remove(@ApiPathParam(name="id")@PathVariable long id) {
		bookingRepository.deleteById(id);
		
		return bookingRepository.findAll();
	}

}
