package com.example.Agenda_B.utils;

import com.example.Agenda_B.domain.User;
import com.example.Agenda_B.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static com.example.Agenda_B.utils.RolesU.*;

public class Helpers {
    public boolean manager2admin(User user, Long new_role){
        if(user==null){
            return false;
        }
        Long current_role=user.getRole().getId();
        if(current_role.equals(MANAGER_ID) && new_role.equals(ADMIN_ID)){
            return true;
        }
        return false;
    }

    public boolean employee2manager(User user, Long new_role){
        Long current_role=user.getRole().getId();
        if(current_role.equals(EMPLOYEE_ID) && new_role.equals(MANAGER_ID)){
            return true;
        }
        return false;
    }
    public boolean employee2admin(User user, Long new_role){
        Long current_role=user.getRole().getId();
        if(current_role.equals(EMPLOYEE_ID) && new_role.equals(ADMIN_ID)){
            return true;
        }
        return false;
    }
    public void setNullManager(User user, UserRepository userRepository){
        user.setManager(null);
        userRepository.save(user);
    }

    public boolean employeeAndmanager(User user,User manager){
        if(user.getRole().getId().equals(EMPLOYEE_ID) && manager.getRole().getId().equals(MANAGER_ID)){
            return true;
        }
        return false;
    }

    public User changeAffectationUser(User user, User manager, UserRepository userRepository){
        if(this.employeeAndmanager(user,manager)){
            user.setManager(manager);
        }
        return userRepository.save(user);
    }

    public User disableUser(User user,UserRepository userRepository,Long id){
        if(user.getRole().getId().equals(MANAGER_ID)){
            List<User> usersOfMangers = userRepository.findAllByManagerUserId(id);
            for(User u:usersOfMangers){
                this.setNullManager(u,userRepository);
            }
        }
        user.setEnabled(false);
        return userRepository.save(user);
    }
}
