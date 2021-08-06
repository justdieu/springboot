package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImp implements UserService{
  private static ArrayList<User> users = new ArrayList<User>();
  static {
      users.add(new User(1,"Nguyen Van A","a@gmail.com","0987453356","avartar1.png","123456"));
      users.add(new User(2,"Nguyen Van B","b@gmail.com","0987457777","avartar2.png","123456"));
      users.add(new User(3,"Nguyen Van C","c@gmail.com","0987457778","avartar3.png","123456"));
      users.add(new User(4,"Nguyen Van D","d@gmail.com","0987457779","avartar4.png","123456"));
  }

    @Override
    public List<UserDto> getListUser() {
      List<UserDto> result = new ArrayList<UserDto>();
      for (User user: users){
            result.add(UserMapper.toUserdto(user));
      }

        return result;
    }

    @Override
    public UserDto getUserbyID(int id) {
         for(User user:users ){
             if(user.getId()==id){
                 return UserMapper.toUserdto(user);
             }

         }
        throw new NotFoundException("User không tồn tại thấy trong hệ thống!");
    }

    @Override
    public List<UserDto> searchUserbyKey(String keyword) {
      List<UserDto> result = new ArrayList<>();
      for (User user:users){
          if (user.getUser().contains(keyword)){
              result.add(UserMapper.toUserdto(user));
          }

      }
      return result;
    }

}
