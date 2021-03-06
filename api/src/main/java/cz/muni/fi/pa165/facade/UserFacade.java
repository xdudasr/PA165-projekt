package cz.muni.fi.pa165.facade;

import java.util.List;


import cz.muni.fi.pa165.dto.CreateUserDTO;
import cz.muni.fi.pa165.dto.UserAuthenticateDTO;
import cz.muni.fi.pa165.dto.UserDTO;
import cz.muni.fi.pa165.enums.AuthenticateUserStatus;


public interface UserFacade {


    public Long createUser(CreateUserDTO newUser);

    public void removeUser(Long id);

    public List<UserDTO> getAllUser();

    public UserDTO getUserByName(String name);

    public UserDTO getUserById(Long id);

    public UserDTO getUserByEmail(String email);

    public void updateUser(UserDTO role);

    public List<UserDTO> getAllUsersByRoleId(Long roleId);

    public Enum<AuthenticateUserStatus> authenticate(UserAuthenticateDTO userAuthenticateDTO);


}