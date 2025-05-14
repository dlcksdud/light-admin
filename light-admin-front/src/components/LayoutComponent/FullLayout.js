import { useSelector } from 'react-redux';
import ContentRoutes from '../../routes/Router.js';
import { useState, createContext } from 'react';
import Header from './Header.js';
import Footer from './Footer.js';
import Sidebar from './Sidebar.js';

export const FullLayoutContext = createContext();

const FullLayout = () => {

    const [closeNav, setCloseNav] = useState('');
    const isLogin = useSelector((state) => state.login);
    const isDisplay = isLogin;
    const areaStyleId = isDisplay ? 'container' : '';
    const contentStyleId = isDisplay ? 'content' : '';
    const changeModeNav = () => {
        if(closeNav === '') {
            setCloseNav('closeNav');
        } else {
            setCloseNav('');
        }
    }

    const onFullLayoutAction = (type, payload) => {
        switch(type) {
            case 'loading':
                // console.log('payload', payload);
                // console.log('isLoading', isLoading);
                // if(payload !== isLoading) {
                //     setIsLoading(payload);
                // }
                break;
            // case 'loading-display-none':
            //     setIsLoading(false);
            //     break;
            default:
                break;
        }
    }

    return (
        <>
            <div id={areaStyleId} className={closeNav} >
            {/* header */}
            {isDisplay && <div id="header">
                <Header changeModeNav={changeModeNav} />
            </div>}
            {/* content */}
            <div id={contentStyleId}>
                <div id="content_area">
                {/* left side nav */}
                {isDisplay && <Sidebar />}
                {/* content */}
                <FullLayoutContext.Provider value={{onFullLayoutAction}}>
                    <ContentRoutes />
                </FullLayoutContext.Provider>
                </div>
            </div>
            {/* footer */}
            {isDisplay && <div id="footer">
                <Footer />
            </div>}
            </div>
        </>
    )
}

export default FullLayout;