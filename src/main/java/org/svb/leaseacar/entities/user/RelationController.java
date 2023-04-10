package org.svb.leaseacar.entities.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/relation")
public class RelationController {

	@Autowired
	private RelationRepository relationRepository;

	@GetMapping
	public List<Relation> findAllRelations() {
		return (List<Relation>) relationRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Relation> findRelationById(@PathVariable(value = "id") long id) {
		Optional<Relation> relation = relationRepository.findById(id);
		return relation.map(value -> ResponseEntity.ok().body(value)).orElseGet(()
				-> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Relation saveUser(@Validated @RequestBody Relation relation) {
		return relationRepository.save(relation);
	}
}
