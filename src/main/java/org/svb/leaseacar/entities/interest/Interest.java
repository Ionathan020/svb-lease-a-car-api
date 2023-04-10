package org.svb.leaseacar.entities.interest;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "interests")
public class Interest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double interestRate;
	private LocalDate startDate;

	public long getId() {
		return id;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Interest interest = (Interest) o;
		return Objects.equals(getId(), interest.getId());
	}
}
