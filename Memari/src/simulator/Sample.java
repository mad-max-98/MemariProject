//Dedicated to Goli

package simulator;

//import java.util.ArrayList;

import simulator.control.*;
import simulator.network.*;
//import simulator.wrapper.*;
import simulator.wrapper.wrappers.*;


public class Sample {
    public static void main(String[] args) {
        //sample circuit
//        Adder adder = new Adder("ADDER", "10X6",
//                Simulator.falseLogic, Simulator.trueLogic, Simulator.trueLogic, Simulator.falseLogic, Simulator.trueLogic,
//                Simulator.falseLogic, Simulator.trueLogic, Simulator.falseLogic, Simulator.falseLogic, Simulator.trueLogic);
//
//        Mux4x1 mux = new Mux4x1("MUX", "6X1", Simulator.falseLogic, Simulator.trueLogic,
//                Simulator.falseLogic, Simulator.trueLogic, Simulator.trueLogic, Simulator.falseLogic);
    	Link [] ln1 = {Simulator.falseLogic , Simulator.trueLogic , Simulator.falseLogic , Simulator.trueLogic } ;
    	Link [] ln2 = {Simulator.falseLogic , Simulator.trueLogic , Simulator.trueLogic , Simulator.falseLogic } ;
    	Link [] aluIn = {Simulator.trueLogic , Simulator.trueLogic , Simulator.falseLogic , Simulator.falseLogic};
    	SignExtend16To32 sgn1 = new SignExtend16To32("SGN1", "4X32", ln1) ;
    	SignExtend16To32 sgn2 = new SignExtend16To32("SGN2", "4X32", ln2) ;
    	ln1 = (Link []) sgn1.getOutputs().toArray(ln1) ;
    	ln2 = (Link []) sgn2.getOutputs().toArray(ln2) ;
    	
    	//System.out.print(aluIn.length + ln1.length + ln2.length);
    	
    	//Xor32 sl1 = new Xor32("XOR" ,"64X32");
    	//Sub32 sl1 = new Sub32("SUB" ,"64X32");
    	//Or32 sl1 = new Or32("Or" ,"64X32");
    	//And32 sl1 = new And32("And" ,"64X32");
    	//Adder sl1 = new Adder("Add" ,"64X32");
    	//Not32 sl1 = new Not32("Not" ,"32X32");
    	//Slt32 sl1 = new Slt32("slt" ,"64X32");
    	//Mux2x1 sl1 = new Mux2x1("MUX", "3X1") ;
    	//sl1.addInput(Simulator.falseLogic);
    	ALU sl1 = new ALU("ALU", "68X32");
    	sl1.addInput(aluIn);
    	sl1.addInput( ln1 );
    	sl1.addInput( ln2 );
    	
        Simulator.debugger.addTrackItem(sl1);
        Simulator.debugger.setDelay(500);
        Simulator.circuit.startCircuit();
    }
}