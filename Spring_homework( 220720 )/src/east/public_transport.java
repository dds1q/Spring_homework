package east;

public abstract class public_transport {
    int number; //버스,택시 넘버
    int max_passengers; // 최대 승객 수
    int current_fuel = 100; // 현재 연료
    int current_speed = 0;  // 현재 속도
    int current_passengers = 0; // 현재 승객 수
    State current_state;   // 현재 상태

    public abstract void change_speed(int speed); // 속도 변경

    public abstract void change_State(State current_state); // 상태 변경

    public void get_on(int passengers) {}  // 탑승( 버스 )
    // 탑승( 택시 )
    public void get_on( int passengers , String destination, int dist ){};

    public abstract void change_fuel(int fuel ); // 연료 변경
}
