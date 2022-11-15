package org.liftoff.project.Repo;

import org.liftoff.project.Models.RegisterModel;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepo extends CrudRepository<Integer, RegisterModel> {
}
