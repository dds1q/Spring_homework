package east;

public class Bus extends public_transport {
    static int pk = 0 ;
    int charge = 1000 ;

    // 초기값 생성성
   public Bus(){
        pk = pk + 1 ;
        number = pk;
        max_passengers = 30;
        current_state = State.운행중;
    }

    // 버스 상태 변경
    public void change_State( State current_state ){
        if( current_state == State.차고지행 ) current_passengers = 0;
        else if( current_fuel < 10 ){
            System.out.println( "주유량이 낮아 운행할 수 없습니다." );
            return;
        }
        this.current_state = current_state;
    }

    // 버스 주유량 변경
    public void change_fuel( int fuel ){
        current_fuel += fuel;
        if( current_fuel < 10 ) System.out.println( "주유 필요" );
    }

    // 버스 속도 변경
    public void change_speed(int speed) {
        this.current_speed += speed;
    }


    // 버스 승객 탑승
    public void get_on( int passengers ) {
        if( passengers + current_passengers > max_passengers ){
            System.out.println("최대 승객 수 초과");
        } else if( current_state.equals("차고지행") ){
            System.out.println("현재 버스가 운행중이지 않습니다.");
        } else{
            current_passengers += passengers;
        }
    }
}
