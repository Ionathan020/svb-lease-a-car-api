package org.svb.leaseacar.entities.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interest")
public class InterestController {
	@Autowired
	private InterestRepository interestRepository;

	@GetMapping
	public List<Interest> findAllInterests() {
		return (List<Interest>) interestRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Interest> findInterestById(@PathVariable(value = "id") long id) {
		Optional<Interest> interests = interestRepository.findById(id);
		return interests.map(value -> ResponseEntity.ok().body(value)).orElseGet(()
				-> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Interest saveInterest(@Validated @RequestBody Interest interest) {
		return interestRepository.save(interest);
	}
}
