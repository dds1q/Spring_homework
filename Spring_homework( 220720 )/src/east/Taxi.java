package east;

public class Taxi extends public_transport {
    static int pk = 0 ;
    int min_charge; // 최소( 기본 ) 요금
    int surcharge;  // 추가 요금
    int min_dist;   // 최소 거리
    int dist_to_destination;    // 목적지까지의 거리
    int earn;   // 총 벌어들인 금액
    String destination; // 목적지명

    public Taxi(){
        pk = pk + 1 ;
        number = pk;
        max_passengers = 4;
        current_state = State.일반;
        min_charge = 3000;
        surcharge = 1000 ;
        min_dist = 1;
        earn = 0;
    }

    // 택시 승객 탑승
    @Override
    public void get_on(int passengers, String destination, int dist) {
        if( passengers > max_passengers ){
            System.out.println("최대 승객 수 초과");
        } else if( current_state == State.운행중 || current_state == State.운행불가 ){
            System.out.println("일반 상태에서만 탑승이 가능합니다.");
        } else{
            current_passengers += passengers;
            this.destination = destination;
            dist_to_destination = dist;
            change_State( State.운행중 );
        }
    }

    //택시 속도 변경
    @Override
    public void change_speed(int speed) {
        this.current_speed += speed;
    }

    // 택시 상태 변경
    @Override
    public void change_State( State current_state ){
        this.current_state = current_state;
    }

    // 택시 연료 변경
    @Override
    public void change_fuel( int fuel ){
        current_fuel += fuel;
    }

    // 택시 요금 계산
    public int chkTotal_charge(){
        if( dist_to_destination <= min_dist ) return min_charge;
        else return min_charge + surcharge * ( dist_to_destination - min_dist );
    }

    // 택시 요금 결제
    public void payment(){
        earn += chkTotal_charge();
        current_passengers = 0;
        destination = "";
        dist_to_destination = 0;
        chk_status();
    }

    // 상태 체크
    public void chk_status(){
        if( this.current_fuel < 10 ) {
            System.out.println( "주유 필요" );
            change_State( State.운행불가 );
        } else {
            change_State( State.일반 );
        }
    }


}
