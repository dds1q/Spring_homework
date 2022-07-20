package east;

public class Main {
    public static void main( String args[] ){
        Bus A = new Bus();
        Bus B = new Bus();
        System.out.println( A.number + " " + B.number );
        A.get_on( 2 );
        System.out.println( "탑승 승객 수 = " + A.current_passengers );
        System.out.println( "잔여 승객 수 = " + ( A.max_passengers - A.current_passengers ) );
        System.out.println( "요금 확인 = " + ( A.current_passengers * A.charge ) );

        A.change_fuel( -50 );
        System.out.println( "주유량 = " + A.current_fuel );

        A.change_State(State.차고지행);

        A.change_fuel( 10 );
        System.out.println( "상태 = " + A.current_state );
        System.out.println( "주유량 = " + A.current_fuel );

        A.change_State(State.운행중);

        A.get_on( 45 );

        A.get_on( 5 );
        System.out.println( "탑승 승객 수 = " + A.current_passengers );
        System.out.println( "잔여 승객 수 = " + ( A.max_passengers - A.current_passengers ) );
        System.out.println( "요금 확인 = " + ( A.current_passengers * A.charge ) );

        A.change_fuel( -55 );
        A.change_State( State.차고지행 );

        System.out.println( "주유량 = " + A.current_fuel );
        System.out.println( "상태 = " + A.current_state );

        System.out.println( "--------------------------------------------------------------");
        System.out.println( "--------------------------------------------------------------");

        Taxi a = new Taxi();
        Taxi b = new Taxi();
        System.out.println( a.number + " " + b.number );

        a.get_on( 2 ,"서울역",2);
        System.out.println( "탑승 승객 수 = " + a.current_passengers );
        System.out.println( "잔여 승객 수 = " + ( a.max_passengers - a.current_passengers ) );
        System.out.println( "기본 요금 확인 = " + a.min_charge );
        System.out.println( "목적지 = " + a.destination );
        System.out.println( "목적지까지 거리 = " + a.dist_to_destination );
        System.out.println( "지불할 요금 = " + a.chkTotal_charge());
        System.out.println( "상태 = " + a.current_state );

        a.change_fuel( -80 );

        a.payment();

        System.out.println( "주유량 = " + a.current_fuel );
        System.out.println( "누적 요금 = " + a.earn );

        a.get_on( 5 , "" , 0 );

        a.get_on( 3 , "구로디지털단지역" , 12 );
        System.out.println( "탑승 승객 수 = " + a.current_passengers );
        System.out.println( "잔여 승객 수 = " + ( a.max_passengers - a.current_passengers ) );
        System.out.println( "기본 요금 확인 = " + a.min_charge );
        System.out.println( "목적지 = " + a.destination );
        System.out.println( "목적지까지 거리 = " + a.dist_to_destination );
        System.out.println( "지불할 요금 = " + a.chkTotal_charge());

        a.change_fuel( -20 );

        a.payment();

        System.out.println( "주유량 = " + a.current_fuel );
        System.out.println( "상태 = " + a.current_state );
        System.out.println( "누적 요금 = " + a.earn );

    }
}
