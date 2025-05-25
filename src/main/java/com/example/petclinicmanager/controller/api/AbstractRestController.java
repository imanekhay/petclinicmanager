package com.example.petclinicmanager.controller.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class AbstractRestController<T, ID> {

    protected final JpaRepository<T, ID> repository;

    // Constructor injection of the repository
    protected AbstractRestController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    // GET all entities
    @GetMapping
    public List<T> getAll() {
        return repository.findAll();
    }

    // GET entity by id
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST create new entity
    @PostMapping
    public T create(@RequestBody T entity) {
        return repository.save(entity);
    }

    // PUT update existing entity - This requires you to override in concrete controller if you want to customize
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entityDetails) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // Save entityDetails directly - assumes entityDetails has the correct ID set

        T updatedEntity = repository.save(entityDetails);
        return ResponseEntity.ok(updatedEntity);
    }

    // DELETE entity by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
