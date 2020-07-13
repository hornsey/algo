package com.hornsey.effectivejava.chapter2;

import com.google.common.base.Objects;
import lombok.NonNull;

import java.util.*;

/**
 * @author huangtao
 * @date 2020/6/27
 */
public class PhoneNumber implements Cloneable,Comparable {
	private Integer areaCode;
	private Integer prefix;
	private Integer lineNum;

	public PhoneNumber(Integer areaCode, Integer prefix, Integer lineNum) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber that = (PhoneNumber) o;
		return Objects.equal(areaCode, that.areaCode) &&
				       Objects.equal(prefix, that.prefix) &&
				       Objects.equal(lineNum, that.lineNum);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(areaCode, prefix, lineNum);
	}

	@Override
	public String toString() {
		return "PhoneNumber{" +
				       "areaCode=" + areaCode +
				       ", prefix=" + prefix +
				       ", lineNum=" + lineNum +
				       '}';
	}

	@Override
	public Object clone() throws CloneNotSupportedException {

		return super.clone();
	}


	public int compareTo1(@NonNull Object o) {

		if (!(o instanceof PhoneNumber)) {
			throw new UnsupportedOperationException("class type error");
		}
		PhoneNumber o2 = (PhoneNumber) o;
		if (!this.areaCode.equals(o2.areaCode)) {
			return this.areaCode - o2.areaCode;
		} else if (!this.prefix.equals(o2.prefix)) {
			return this.prefix - o2.prefix;
		} else if (!this.lineNum.equals(o2.lineNum)) {
			return this.lineNum - o2.lineNum;
		}
		return 0;
	}

	@Override
	public int compareTo(@NonNull Object o) {
		return COMPARATOR.compare(this, (PhoneNumber) o);
	}

	private static final Comparator<PhoneNumber> COMPARATOR =
			Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
			.thenComparingInt(pn -> pn.prefix)
			.thenComparingInt(pn -> pn.lineNum);

	public static void main(String[] args) {
		PhoneNumber ph1 = new PhoneNumber(10, 8, 2341);
		PhoneNumber ph2 = new PhoneNumber(10, 9, 2341);
		PhoneNumber ph3 = new PhoneNumber(7, 8, 2341);
		PhoneNumber ph4 = new PhoneNumber(7, 8, 2340);
		Set<PhoneNumber> set = new TreeSet<>();
		set.add(ph1);
		set.add(ph2);
		set.add(ph3);
		set.add(ph4);
		System.out.println(set);
	}

}
