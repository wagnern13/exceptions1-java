package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	// Colocando o static, esse objeto será instanciado apenas uma vez. 
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Utilizando RuntimeExceptio não é obrigado a utilizar throws
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
//	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	// Utilizando RuntimeExceptio não é obrigado a utilizar throws
	
	public void updateDates(Date checkIn, Date checkOut)  {
//	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
//			throw new IllegalArgumentException("Reservation dates for update must be future dates");
			throw new DomainException("Reservation dates for update must be future dates");
		}  
		if (!checkOut.after(checkIn)) {
//			throw new IllegalArgumentException("Check-out date must be after check-in date");
			throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duration()
			+ " nights";
	}

}
