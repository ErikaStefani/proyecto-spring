export interface AuthorizationInfoDto {
  principal: UserInfoDto;
  authenticated: boolean;
}

export interface UserInfoDto {
  username: string;
}

export class AuthorizationInfo {

  constructor(private authorizationInfoDto: AuthorizationInfoDto) { }

  static create(authorizationInfoDto: AuthorizationInfoDto) {
    return new AuthorizationInfo(authorizationInfoDto);
  }

  authenticated(){
    if(this.authorizationInfoDto){
      return this.authorizationInfoDto.authenticated;
    }
    return false;
  }

  currentUserName(){
    if(this.authorizationInfoDto){
      return this.authorizationInfoDto.principal.username;
    }
    return '';
  }
}

export interface UserModel {
  name: string;
  password: string;
}
