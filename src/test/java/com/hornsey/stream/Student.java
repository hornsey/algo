package com.hornsey.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * @author huangtao
 * @date 2020/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name;
	private String school;
	private String gender;
	private int age;
	private double score;

}
