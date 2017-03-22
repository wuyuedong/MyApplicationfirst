package com.example.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dd on 2017/3/8.
 */

public class HotOrGoodBean implements Serializable {

    //    {
//        "map": {
//                "total": 27,
//                "list": [
//              {
//                 "id": "11",
//                "name": "测试9",
//                "icon": "http://img.jsie.org.cn/dynamic/ar/ae4edc1100be42bb8a72fe39a909b3df.png",
//                "price": "0.01",
//                "stars": "0"
//              }
//        ]
//       }
//        "errmsg": "success",
//        "errcode": 0
//       }
    private String errmsg;
    private int errcode;
    private HotOrGoodSonBean map ;

    public HotOrGoodBean(){

    }

    public HotOrGoodSonBean getMap() {
        return map;
    }

    public void setMap(HotOrGoodSonBean map) {
        this.map = map;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }



   public static class HotOrGoodSonBean {
        private int total;
        private ArrayList<HotOrGoodSonSonBean> list = new ArrayList<>();

       public HotOrGoodSonBean(){}

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public ArrayList<HotOrGoodSonSonBean> getList() {
            return list;
        }

        public void setList(ArrayList<HotOrGoodSonSonBean> list) {
            this.list = list;
        }

       public static class HotOrGoodSonSonBean{
            private String id;
            private String name;
            private String icon;
            private String price;
            private String stars;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }
        }
    }

}
