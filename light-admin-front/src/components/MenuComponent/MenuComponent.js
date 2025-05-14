import React from 'react'
import Stack from '@mui/material/Stack';
import Popper from '@mui/material/Popper';
import Grow from '@mui/material/Grow';
import ClickAwayListener from '@mui/material/ClickAwayListener';
import MenuItem from '@mui/material/MenuItem';
import MenuList from '@mui/material/MenuList';
import Paper from '@mui/material/Paper';
import settingIcon from '../../assets/images/settingIcon.png';
import userIcon from '../../assets/images/userIcon.png';

const MenuComponent = (props) => {

    const {menuData, type='setting', onAction} = props

    const [open, setOpen] = React.useState(false);
    const anchorRef = React.useRef(null);

    const handleToggle = () => {
        setOpen((prevOpen) => !prevOpen);
    };

    const handleClose = (event) => {
        if (anchorRef.current && anchorRef.current.contains(event.target)) {
        return;
        }

        setOpen(false);
    };

    function handleListKeyDown(event) {
        if (event.key === 'Tab') {
        event.preventDefault();
        setOpen(false);
        } else if (event.key === 'Escape') {
        setOpen(false);
        }
    }

    const onComponentAction = (type, payload) => {
        setOpen(false);
        onAction(type, payload);
    }

    // return focus to the button when we transitioned from !open -> open
    const prevOpen = React.useRef(open);
    React.useEffect(() => {
        if (prevOpen.current === true && open === false) {
        anchorRef.current.focus();
        }

        prevOpen.current = open;
    }, [open]);

    const imgIcon = type === 'setting' ? settingIcon : userIcon;

  return (
    <Stack direction="row" spacing={2}>
    <div style= {{cursor:'pointer'}}>
        <img src={imgIcon} 
          style={{width:'20px'}}
          alt="그룹 설정" 
          ref={anchorRef}
          id="composition-button"
          aria-controls={open ? 'composition-menu' : undefined}
          aria-expanded={open ? 'true' : undefined}
          aria-haspopup="true"
          onClick={handleToggle}></img>
        
      <Popper
        open={open}
        anchorEl={anchorRef.current}
        role={undefined}
        placement="bottom-start"
        transition
        disablePortal
      >
        {({ TransitionProps, placement }) => (
          <Grow
            {...TransitionProps}
            style={{
              transformOrigin:
                placement === 'bottom-start' ? 'left top' : 'left bottom',
            }}
          >
            <Paper>
              <ClickAwayListener onClickAway={handleClose}>
                <MenuList
                  autoFocusItem={open}
                  id="composition-menu"
                  aria-labelledby="composition-button"
                  onKeyDown={handleListKeyDown}
                >
                  {menuData.map((item, idx) => {
                      return (
                            <MenuItem 
                                  key={idx} 
                                  sx={{height:'25px;', fontSize:'13px', fontFamily: "font-family: 'NanumBarunGothic', sans-serif;"}} 
                                  onClick={() => onComponentAction(`menu-click`, item.type)}>
                              {item.title}
                            </MenuItem>
                          );
                  })}
                  {/* <MenuItem onClick={()=>onAction('test', '111')}>Profile</MenuItem>
                  <MenuItem onClick={handleClose}>My account</MenuItem>
                  <MenuItem onClick={handleClose}>Logout</MenuItem> */}
                </MenuList>
              </ClickAwayListener>
            </Paper>
          </Grow>
        )}
      </Popper>
    </div>
  </Stack>
  )
}

export default MenuComponent