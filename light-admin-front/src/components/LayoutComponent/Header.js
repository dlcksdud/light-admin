import React from 'react'
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import brandLogo from '../../assets/images/logo.png';
import brandText from '../../assets/images/textlogo.png';
import MenuComponent from '../MenuComponent/MenuComponent';
import { logout } from '../../functions/Common';
import { UserLogoutAction } from '../../actions/LoginAction/Login';

const Header = ({changeModeNav}) => {

  const navigate = useNavigate();
  let user = useSelector((state) => state.user);

  const menuData = [
    {type: 'userInfo', title: '내 정보'},
    {type: 'logout', title: '로그아웃'},
  ]

  const onComponentAction = (type, payload) => {
    switch(type) {
        case 'menu-click':
            if (payload === 'userInfo') {
                navigate(`users/detailMyPage/${user.userInfo.id}`);
                // navigate(`users/confirmPassword/${user.userInfo.id}`);
            } else if (payload === 'logout') {
                userLogout();
            }
        break;
    default:
        break;
    }
  }

  const userLogout = async () => {
    const res = await UserLogoutAction(user.userInfo.id);
    logout();
    navigate("/login");
  }

  return (
    <>
      <div className="header_area">
          <div className="hd_logo_wrap">
              <div className="hd_logo">
                  <Link to="/dashBoard/dashBoard">
                      <span className="brand_logo"><img src={brandLogo} alt="관리자 로고"></img></span>
                      <span className="brand_text"><img src={brandText} alt="라이트 어드민"></img></span>
                  </Link>
              </div>
          </div>

          <div className="hd_menu">
              <div className="hamburger nav-toggle">
                  <a onClick={changeModeNav}>
                      <i className="la la-bars"></i>
                  </a>
              </div>
              <div className="brand_text02">sWallet 관리 시스템<span className="brand_text02_s"></span></div>
          </div>
          <div className="hd_user">
              <span className='user_name'>{user.userInfo.name}</span>
              <MenuComponent menuData={menuData} type='user' onAction={onComponentAction}/>
          </div>
      </div>
    </>
  )
}

export default Header