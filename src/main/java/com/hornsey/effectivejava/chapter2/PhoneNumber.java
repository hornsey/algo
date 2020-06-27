package com.hornsey.effectivejava.chapter2;

import com.google.common.base.Objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangtao
 * @date 2020/6/27
 */
public class PhoneNumber implements Cloneable{
	private Integer areaCode;
	private Integer prefix;
	private Integer lineNum;
	private List<Integer> calls;

	public PhoneNumber(Integer areaCode, Integer prefix, Integer lineNum) {
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.lineNum = lineNum;
		this.calls = new ArrayList<>();
	}

	public List<Integer> getCalls() {
		return calls;
	}

	public void setCalls(List<Integer> calls) {
		this.calls = calls;
	}

	public void addCall(Integer x) {
		this.calls.add(x);
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
}
