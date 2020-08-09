package com.hornsey.effectivejava.chapter12;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author huangtao
 * @date 2020/8/9
 */
public class MutalePeriod {
	public Period period;
	public Date start;
	public Date end;

	public MutalePeriod() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(new Period(new Date(), new Date()));

			byte[] ref = {0x71, 0, 0x7e, 0, 5};
			// the start field
			bos.write(ref);
			ref[4] = 4;
			bos.write(ref);

			ObjectInputStream in = new ObjectInputStream(
					new ByteArrayInputStream(bos.toByteArray())
			);
			period = (Period) in.readObject();
			start = (Date) in.readObject();
			end = (Date) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MutalePeriod mp = new MutalePeriod();
		Period p = mp.period;
		Date pEnd = mp.end;
		LocalDateTime localDate = LocalDateTime.now();
		ZoneId zoneId = ZoneId.systemDefault();
		localDate = localDate.minusYears(20);
		Instant instant = localDate.atZone(zoneId).toInstant();
		System.out.println(instant.toString());
		pEnd.setTime(Date.from(instant).getTime());
		System.out.println(p);


	}
}
