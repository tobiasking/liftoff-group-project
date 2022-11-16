package org.liftoff.project.data;

import org.liftoff.project.Models.RegisterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends CrudRepository<RegisterModel, Integer> {
}
