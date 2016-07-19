package com.meal.activity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import com.meal.action.MenuConfigAction;
import com.meal.action.UserManageAction;
import com.meal.activity.ipml.AsynThreadImpl;
import com.meal.activity.ipml.UIThreadImpl;
import com.meal.bean.Constant;
import com.meal.bean.Global;
import com.meal.bean.User;
import com.meal.util.DialogUtil;
import com.meal.util.FileUtils;
import com.meal.util.HttpUtil;
import com.meal.util.JSONFactoryUtil;

/**
 * @author xiamingxing
 *
 */
public class TestActivity extends BaseActivity {

    private HashMap<String, String> loginInfo = new HashMap<String, String>();

    private User user = null;

    private UserManageAction userManage = UserManageAction.getInstance();

    private MenuConfigAction menuConfig = MenuConfigAction.getInstance();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        initial();

        addEventListener();

    }

    private void initial() {
        // TODO Auto-generated constructor stub
        setUIRefreshConfig(new UIThreadImpl() {
            @Override
            public void refresh(Message msg) {
                // TODO Auto-generated method stub

                String content = "";

//				{
//					ImageView imageView = (ImageView) findViewById(R.id.image_test);
//					imageView.setImageBitmap((Bitmap) msg.obj);
//				}
//				
//				{
//					User user = (User) msg.obj;
//					String content = JSONFactoryUtil.parserToJsonString(user);

//				}

//				{
//					
//					content = msg.obj.toString();
//				}

                {
                    content = JSONFactoryUtil.parserToJsonString(msg.obj);

                }


                DialogUtil.alert(content, TestActivity.this);
            }
        });

        setAsynThreadConfig("login", true, new AsynThreadImpl() {

            @Override
            public Message excute() {
                // TODO Auto-generated method stub
                Message msg = Message.obtain();

                msg.obj = userManage.login(loginInfo.get("userName"),
                        loginInfo.get("passWord"));

                finishAsynThread("login");

                return msg;
            }

        });

        setAsynThreadConfig("register", true, new AsynThreadImpl() {

            @Override
            public Message excute() {
                // TODO Auto-generated method stub
                Message msg = Message.obtain();

                if (userManage.register(user)) {


                    msg.obj = Global.user;
                }

                finishAsynThread("register");

                return msg;
            }

        });

        setAsynThreadConfig("test", true, new AsynThreadImpl() {

            @Override
            public Message excute() {
                // TODO Auto-generated method stub
                Message msg = Message.obtain();
                //Global.seller = new Seller();
                Global.user = new User("sunxiaojun", "123456",
                        null, "18010050656", "北京市");

//				{
//					userManage.updateUserInfo(new User("sunxiaojun", "123456",
//							null, "18010050656", "北京市"));
//					msg.obj = Global.user;
//				}

//				{
//					Bitmap bmp = userManage.getUserPortrait("http://tb.himg.baidu.com/sys/portrait/item/25387869615f6d696e6778696e675f0a");
//					bmp = userManage.getUserPortrait("http://tb.himg.baidu.com/sys/portrait/item/25387869615f6d696e6778696e675f0a");
//					msg.obj = bmp;
//				}
                
                {
                	try {
						File file = FileUtils.creatSDFile("test");
						HttpUtil.Upload(Constant.USER_MODULE, "uid=" + Global.user.getUid(), file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }

//				{
//					
//					Global.seller = new Seller();
//					msg.obj = menuConfig.addMenu(new Menu("糖醋里脊", null, 100l, 0.8));
//					
//				}


//				{
//					
//					msg.obj = menuConfig.getMenuDetail(1l);
//				}

//				{
//					
//					menuConfig.updateMenu(1l, new Menu("糖醋里脊", null, 100l, 0.8));
//					
//				}


//				{
//					msg.obj = menuConfig.getMenuList(1l);
//					
//				}

//				{
//					menuConfig.deleteMenu(1l);
//					
//				}

//				{
//					menuConfig.clearMenuListBySid(1l);
//					
//				}

                {


                }


                finishAsynThread("test");
                return msg;
            }

        });

    }

    private void addEventListener() {

        final EditText edt_passWord = (EditText) findViewById(R.id.editText_passWord);

        final EditText edt_userName = (EditText) findViewById(R.id.editText_userName);

        addClickEventListener(R.id.btn_submit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = edt_userName.getText().toString();

                String passWord = edt_passWord.getText().toString();

                loginInfo.put("userName", "xiamingxing");

                loginInfo.put("passWord", "123456");

                startAsynThread("login");

            }
        });

        addClickEventListener(R.id.btn_register, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                user = new User("xiamingxing", "123456", null, "18010050656",
                        "北京市");

                startAsynThread("register");

            }
        });

        addClickEventListener(R.id.btn_test, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                startAsynThread("test");

            }
        });
    }
}
