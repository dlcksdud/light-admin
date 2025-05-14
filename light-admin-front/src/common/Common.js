//@@ 백엔드 서버 URL
// export const SERVER_URL = 'http://localhost:9090';
export const SERVER_URL = `${process.env.REACT_APP_URL}:${process.env.REACT_APP_PORT}`;
// export const SERVER_URL = 'http://14.32.171.185:9090';
//@@ 인터페이스 URI 목록
export const URI = {};
URI.SERVICE_ROOT = '/office';
// 공통
URI.LOGIN = URI.SERVICE_ROOT + '/login';
URI.LOGOUT = URI.SERVICE_ROOT + '/logout';
URI.REFRESH_TOKEN = URI.SERVICE_ROOT + '/refreshtoken';
URI.MENU = URI.SERVICE_ROOT + '/menu';

// 관리자
URI.ADMIN_LIST = URI.SERVICE_ROOT + '/admin/list';
URI.ADMIN_INFO = URI.SERVICE_ROOT + '/admin/:adminId/info';
URI.ADMIN_DELETE = URI.SERVICE_ROOT + '/admin/:adminId';
URI.ADMIN_EDIT = URI.SERVICE_ROOT + '/admin/update';
URI.ADMIN_PASSWORD_EDIT = URI.SERVICE_ROOT + '/admin/password/update';
URI.ADMIN_NEW = URI.SERVICE_ROOT + '/admin/new';
URI.ADMIN_CHECK = URI.SERVICE_ROOT + '/admin/:adminId/check';
URI.ADMIN_GROUP = URI.SERVICE_ROOT + '/admin/group/update';

URI.GROUP_IN_ADMIN_LIST = URI.SERVICE_ROOT + '/admin/:adminId/group';

URI.API_ADMIN_GROUP = URI.SERVICE_ROOT + '/api/group/update';

// 역할
URI.ROLE_EDIT = URI.SERVICE_ROOT + '/admin/role';

// 메뉴
URI.MENU_LIST = URI.SERVICE_ROOT + '/admin/menu';
URI.MENU_EDIT = URI.SERVICE_ROOT + '/admin/menu/update';
URI.MENU_ROLE_LIST = URI.SERVICE_ROOT + '/admin/menu/:menuName/role';
URI.MENU_ROLE_EDIT = URI.SERVICE_ROOT + '/admin/menu/:menuName/role';

// Log
URI.LOG_LIST = URI.SERVICE_ROOT + '/admin/access/log';
URI.LOG_INFO = URI.SERVICE_ROOT + '/admin/access/log/:adminId/:dateTime';

// 그룹
URI.GROUP_JOIN_ADMIN_LIST = URI.SERVICE_ROOT + '/admin/groupid/:groupId/list';

URI.API_GROUP_INFO = URI.SERVICE_ROOT + '/api/group/groupid/:groupId';
URI.API_GROUP_LIST = URI.SERVICE_ROOT + '/api/group/search';
URI.API_GROUP_LIST_GROUPID = URI.SERVICE_ROOT + '/api/group/groupid/:groupId';
URI.API_GROUP_NEW = URI.SERVICE_ROOT + '/api/group/new';
URI.API_GROUP_EDIT = URI.SERVICE_ROOT + '/api/group';
URI.API_GROUP_ID_CHECK = URI.SERVICE_ROOT + '/api/group/groupid/:groupId/check';

// account
URI.API_ACCOUNT_LIST = URI.SERVICE_ROOT + '/api/account/search';
URI.API_ACCOUNT_NEW = URI.SERVICE_ROOT + '/api/account/new';
URI.API_ACCOUNT_EDIT = URI.SERVICE_ROOT + '/api/account/update';
URI.API_ACCOUNT_INFO = URI.SERVICE_ROOT + '/api/account/account/:account';
URI.API_ACCOUNT_DELETE = URI.SERVICE_ROOT + '/api/account/delete';


// auditLog
URI.AUDITLOG_LIST = URI.SERVICE_ROOT + '/admin/access/log';
URI.AUDITLOG_INFO = URI.SERVICE_ROOT + '/admin/access/log/:userId/:dateTime';
URI.WALLETLOG_LIST = URI.SERVICE_ROOT + '/api/log/search';
URI.WALLETLOG_INFO = URI.SERVICE_ROOT + '/api/log/:seq/:requesterSearchValue';

URI.API_STATE_CODE = URI.SERVICE_ROOT + '/api/group/statecode';

/************************************************************************/
// 셀렉트박스 아이템
/************************************************************************/
// export const USER_AUTH_MAP = [
//     {label:'ROLE_GROUP_ADMIN', value: 2},
//     {label:'ROLE_GROUP_USER', value: 3},
//     {label:'ROLE_AUDITOR', value: 4},
// ]
export const USER_AUTH_MAP = [
  {label:'ROLE_SECURITY_OFFICER', value: 'ROLE_SECURITY_OFFICER'},
  {label:'ROLE_GROUP_ADMIN', value: 'ROLE_GROUP_ADMIN'},
  {label:'ROLE_GROUP_USER', value: 'ROLE_GROUP_USER'},
  {label:'ROLE_AUDITOR', value: 'ROLE_AUDITOR'},
]

//활성 비활성 셀렉트박스 아이템 - 관리자
export const STATUS_ACTIVATION = [
  {label:'활성', value: '00'},
  {label:'비활성', value: '90'},
]

//활성 비활성 셀렉트박스 아이템 - 그룹
export const STATUS_WALLET_ACTIVATION = [
  {label:'활성', value: '00'},
  {label:'비활성', value: '90'},
]

// 키 status
export const STATUS_WALLET_KEY_ACTIVATION = [
  {label: '정상', value: '00'},
  {label: '승인 대기', value: '10'},
  {label: '정지', value: '20'},
  {label: '폐기', value: '90'},
]

// 키 저장방식 storageType
export const STORAGETYPE_WALLET_KEY_ACTIVATION = [
  {label: '단일키', value: '00'},
  {label: 'SSS', value: '10'},
  {label: 'MPC', value: '20'},
]

// 관리자 접속로그 리스트 검색 : 페이지
export const CURRENT_PAGE_SELECTBOX = [
  {label: 'LOGIN_PAGE', value: 'LOGIN_PAGE'},
  {label: 'DASHBOARD_PAGE', value: 'DASHBOARD_PAGE'},
  {label: 'GROUP_ADD_PAGE', value: 'GROUP_ADD_PAGE'},
  {label: 'GROUP_EDIT_PAGE', value: 'GROUP_EDIT_PAGE'},
  {label: 'GROUP_DETAIL_PAGE', value: 'GROUP_DETAIL_PAGE'},
  {label: 'GROUP_LIST_PAGE', value: 'GROUP_LIST_PAGE'},
  {label: 'GROUP_MANAGE_LIST_PAGE', value: 'GROUP_MANAGE_LIST_PAGE'},
  {label: 'ACCOUNT_EDIT_PAGE', value: 'ACCOUNT_EDIT_PAGE'},
  {label: 'ACCOUNT_DETAIL_PAGE', value: 'ACCOUNT_DETAIL_PAGE'},
  {label: 'ACCOUNT_DELETE_PAGE', value: 'ACCOUNT_DELETE_PAGE'},
  {label: 'ACCOUNT_LIST_PAGE', value: 'ACCOUNT_LIST_PAGE'},
  {label: 'KEY_EDIT_PAGE', value: 'KEY_EDIT_PAGE'},
  {label: 'KEY_DETAIL_PAGE', value: 'KEY_DETAIL_PAGE'},
  {label: 'KEY_DELETE_PAGE', value: 'KEY_DELETE_PAGE'},
  {label: 'KEY_LIST_PAGE', value: 'KEY_LIST_PAGE'},
  {label: 'ADMIN_CONNECT_LOG_PAGE', value: 'ADMIN_CONNECT_LOG_PAGE'},
  {label: 'ADMIN_CONNECT_LOG_DETAIL_PAGE', value: 'ADMIN_CONNECT_LOG_DETAIL_PAGE'},
  {label: 'WALLET_LOG_PAGE', value: 'WALLET_LOG_PAGE'},
  {label: 'WALLET_LOG_DETAIL_PAGE', value: 'WALLET_LOG_DETAIL_PAGE'},
  {label: 'ADMIN_ADD_PAGE', value: 'ADMIN_ADD_PAGE'},
  {label: 'ADMIN_EDIT_PAGE', value: 'ADMIN_EDIT_PAGE'},
  {label: 'ADMIN_DETAIL_PAGE', value: 'ADMIN_DETAIL_PAGE'},
  {label: 'ADMIN_LIST_PAGE', value: 'ADMIN_LIST_PAGE'},
  {label: 'ADMIN_PASSWORD_EDIT_PAGE', value: 'ADMIN_PASSWORD_EDIT_PAGE'},
  {label: 'ROLES_MANAGE_PAGE', value: 'ROLES_MANAGE_PAGE'},
  {label: 'MENU_MANAGE_PAGE', value: 'MENU_MANAGE_PAGE'},
  {label: 'GROUP_MANAGE_PAGE', value: 'GROUP_MANAGE_PAGE'},
]

export const CURRENT_PAGE = {
  // 로그인
  loginPage: 'LOGIN_PAGE',
  // 마이 페이지(내 정보)
  myPageDetail: 'MY_PAGE_DETAIL',
  myPageUpdate: 'MY_PAGE_UPDATE',
  // 대시보드
  dashBoardPage: 'DASHBOARD_PAGE',
  // 그룹
  groupAddPage: 'GROUP_ADD_PAGE',
  groupEditPage: 'GROUP_EDIT_PAGE',
  groupDetailPage: 'GROUP_DETAIL_PAGE',
  groupListPage: 'GROUP_LIST_PAGE',
  groupManageListPage: 'GROUP_MANAGE_LIST_PAGE',
  // 계정
  accountEditPage: 'ACCOUNT_EDIT_PAGE',
  accountDetailPage: 'ACCOUNT_DETAIL_PAGE',
  accountDeletePage: 'ACCOUNT_DELETE_PAGE',
  accountListPage: 'ACCOUNT_LIST_PAGE',
  // 키
  keyEditPage: 'KEY_EDIT_PAGE',
  keyDetailPage: 'KEY_DETAIL_PAGE',
  keyDeletePage: 'KEY_DELETE_PAGE',
  keyListPage: 'KEY_LIST_PAGE',
  // LOG
  adminConnectLogPage: 'ADMIN_CONNECT_LOG_PAGE',
  adminConnectLogDetailPage: 'ADMIN_CONNECT_LOG_DETAIL_PAGE',
  walletLogPage: 'WALLET_LOG_PAGE',
  walletLogDetailPage: 'WALLET_LOG_DETAIL_PAGE',
  // 관리자
  adminAddPage: 'ADMIN_ADD_PAGE',
  adminEditPage: 'ADMIN_EDIT_PAGE',
  adminDetailPage: 'ADMIN_DETAIL_PAGE',
  adminListPage: 'ADMIN_LIST_PAGE',
  adminPasswordEditPage: 'ADMIN_PASSWORD_EDIT_PAGE', // 2023/01/19 추가
  // 역할
  rolesManagePage: 'ROLES_MANAGE_PAGE',
  // 메뉴
  menuManagePage: 'MENU_MANAGE_PAGE',
  // 그룹관리
  groupManagePage: 'GROUP_MANAGE_PAGE',

}

export const CURRENT_EVENT = {
  search: 'SEARCH',
  add: 'ADD',
  edit: 'EDIT',
  delete: 'DELETE',
}

/**
 * 유효성 검사
 * 
 * input 값 들어있지 않으면 불합격
 * [쓸 곳]
 * 1. 운영자 등록 : 권한, 아이디, 비번, 비번확인, 이름, 부서명, 이메일, 연락처 - 총 8개
 * 2. 운영자 수정 : 이름, 부서, 이메일, 연락처 - 총 4개
 * 3. 키 생성 : 키이름, 기관, 설명 - 총 3개
*/
export const VALIDATION = {
  // 공통적인걸 생각하면!
  // input값은 해당 페이지에서 가져와야 함.
  // 1. 모든 INPUT값의 길이는 0이상!
  INPUT_LENG : 0,
  // 2. INPUT값의 길이가 0 미만이면 alert("빈칸이 있습니다.")
  // EMPTYALERT : alert("빈칸이 있습니다."),
  
  // 특수 문자
  SPECIALLETTER : /[`~!@@#$%^&*|₩₩₩'₩"\;\:₩/?]/gi,
  // 연락처에 숫자 이외의 것
  NOTNUM : /[^0-9]/,

  // 공백
  BLANK : /\s/g,

}

export const PAGING = {
  PAGE_INIT : 1,
  COUNT_OPTION_INIT : 10,
  count_option: [
      {
          "idx" : "1",
          "value" : 10,
          "name" : "10개"
      },
      {
          "idx" : "2",
          "value" : 20,
          "name" : "20개"
      },
      {
          "idx" : "3",
          "value" : 30,
          "name" : "30개"
      }
  ]   
}

// 모달
export const MODAL_CONTENT = {};
MODAL_CONTENT.SAVE = '등록되었습니다.';
MODAL_CONTENT.EDIT = '수정되었습니다.';
MODAL_CONTENT.DELETE = '삭제되었습니다.';
MODAL_CONTENT.GROUPSAVE = '그룹이 등록되었습니다. 그룹관리 페이지로 이동하시겠습니까?';

// 모달 error
MODAL_CONTENT.ADMIN_ERROR = '관리자에게 문의바랍니다.';

// 그룹모달 error
MODAL_CONTENT.GROUP_ID_ERROR = '그룹 아이디를 작성해주세요.';

// 역할에 페이지를 조회할 경우
MODAL_CONTENT.PATH_ERROR = '잘못된 경로입니다.';
