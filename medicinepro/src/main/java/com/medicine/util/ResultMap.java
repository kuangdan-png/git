package com.medicine.util;

/**
 * @Auther: 刘涵
 * @Date: 2019/11/19 0019 11:02
 * @Description:
 */
public class ResultMap<T> {
        private String msg;
        private  T row;
        private  int status;
        private  int count;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getrow() {
            return row;
        }

        public void setrow(T row) {
            this.row = row;
        }

        public int getstatus() {
            return status;
        }

        public void setstatus(int status) {
            this.status = status;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public ResultMap(String msg, T row, int status, int count) {
            this.msg = msg;
            this.row = row;
            this.status = status;
            this.count = count;
        }

        public ResultMap() {
        }

    @Override
    public String toString() {
        return "ResultMap{" +
                "msg='" + msg + '\'' +
//                ", row=" + row +
                ", status=" + status +
                ", count=" + count +
                '}';
    }
}
