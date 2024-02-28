/**
 * Another game AI that could be used to set up enemies
 * Bugs need to be fixed, cannot work right now
 */
//package Main;
//
//import Roles.*;
//import java.awt.*;
//import java.util.*;
//
//import Object.*;
//
//public class enemySet2 extends enemySet {
//
//    public Panel panel;
//    public enemyAI enemy1,enemy2,enemy3;
//    public double heuristic;
//    public Map<String,Double> weightMap = new HashMap<>();
//    public Map<String,Direction> directionMap = new HashMap<>();
//
//    public enemySet2(Panel panel){
//        super(panel);
//        enemy1 = new enemyAI(panel);
//        this.panel.enemyCopyOnWriteArrayList.add(enemy1);
//        enemy1.setEnemySetter(this);
//
//        enemy2 = new enemyAI(panel);
//        enemy2.posX = 3*Panel.tileSize; enemy2.posY = 7*Panel.tileSize;
//        this.panel.enemyCopyOnWriteArrayList.add(enemy2);
//        enemy2.setEnemySetter(this);
//
//        enemy3 = new enemyAI(panel);
//        enemy3.posX = 16*Panel.tileSize; enemy3.posY = 9*Panel.tileSize;
//        this.panel.enemyCopyOnWriteArrayList.add(enemy3);
//        enemy3.setEnemySetter(this);
//
//        directionMap.put("down",Direction.DOWN);directionMap.put("up",Direction.UP);
//        directionMap.put("left",Direction.LEFT);directionMap.put("right",Direction.RIGHT);
//    }
//
//
//    public void update(Boolean imageAdjust){
//        for(enemyAI e: panel.enemyCopyOnWriteArrayList){
//            e.update(imageAdjust);
//        }
//    }
//
//
////    public Direction findBestDirection(enemyAI e){
////        weightMap.put("up",0.0);
////        weightMap.put("down",0.0);
////        weightMap.put("left",0.0);
////        weightMap.put("right",0.0);
////        //findPath(e);
////        double maxWeight = weightMap.get("up");
////        for(Double d: weightMap.values()){
////            if(d>maxWeight) maxWeight = d;
////        }
////        for(String s: weightMap.keySet()){
////            if(weightMap.get(s) == maxWeight) return directionMap.get(s);
////        }
////        return null;
////    }
////
////    public void findPath(enemyAI e){
////        for(String s: weightMap.keySet()){
////            e.direction = directionMap.get(s);
////            pathCheck(e);
////        }
////    }
////
////    public void pathCheck(enemyAI e){
////        int roleLeftX = e.posX+e.collisionArea.x;
////        int roleRightX = roleLeftX+e.collisionArea.width;
////        int roleTopY = e.posY+e.collisionArea.y;
////        int roleBottomY = roleTopY+e.collisionArea.height;
////        int roleLeftCol = roleLeftX/Panel.tileSize;
////        int roleRightCol = roleRightX/Panel.tileSize;
////        int roleTopRow = roleTopY/Panel.tileSize;
////        int roleBottomRow = roleBottomY/Panel.tileSize;
////        int tileNum1, tileNum2;
////
////        if(e.direction == Direction.UP){
////            roleTopRow = (roleTopY-e.speed)/Panel.tileSize;
////            tileNum1 = panel.Map.canvas[roleTopRow][roleLeftCol];
////            tileNum2 = panel.Map.canvas[roleTopRow][roleRightCol];
////
////            bombCheck(e,"up");
////
////            if(tileNum1 == 0 || tileNum2 == 0){
////                //heuristic = Math.pow((e.posX/Panel.tileSize-panel.player.posX/Panel.tileSize),2)+Math.pow((e.posY/Panel.tileSize-panel.player.posY/Panel.tileSize),2);
////                //heuristic = Math.abs(e.posX-panel.player.posX)+Math.abs(e.posY-panel.player.posY);
////                //weightMap.put("up", weightMap.get("up")-heuristic);
////                weightMap.put("up", weightMap.get("up")+15);
////            }
////            else if(tileNum1 == 1 || tileNum2 == 1){
////                e.collisionDetected = true;
////                //weightMap.put("up",weightMap.get("up"));
////            }
////            else if(tileNum1 == 2 || tileNum2 == 2){
//////                int indicator = 1;
////                e.collisionDetected = true;
////                //weightMap.put("up",weightMap.get("up"));
//////                if(tileNum1 == 2 && tileNum2 != 2) indicator = 1;
//////                if(tileNum1 != 2 && tileNum2 == 2) indicator = 2;
//////                if(tileNum1 == 2 && tileNum2 == 2) indicator = 3;
////
//////                if(canPlaceBomb("up",e,indicator)){
//////                    placeBomb(e);
//////                }
////            }
////        }
////
////        else if(e.direction == Direction.DOWN){
////            roleBottomRow = (roleBottomY+e.speed)/Panel.tileSize;
////            tileNum1 = panel.Map.canvas[roleBottomRow][roleLeftCol];
////            tileNum2 = panel.Map.canvas[roleBottomRow][roleRightCol];
////
////            bombCheck(e,"down");
////
////            if(tileNum1 == 0 || tileNum2 == 0){
////                //heuristic = Math.sqrt(Math.pow((e.posX/Panel.tileSize-panel.player.posX/Panel.tileSize),2)+Math.pow((e.posY/Panel.tileSize-panel.player.posY/Panel.tileSize),2));
////                //heuristic = Math.abs(e.posX-panel.player.posX)+Math.abs(e.posY-panel.player.posY);
////                //weightMap.put("down", weightMap.get("down")-heuristic);
////                weightMap.put("down", weightMap.get("down")+15);
////            }
////            else if(tileNum1 == 1 || tileNum2 == 1){
////                e.collisionDetected = true;
////                //weightMap.put("down",weightMap.get("down"));
////            }
////            else if(tileNum1 == 2 || tileNum2 == 2){
////                e.collisionDetected = true;
////                //weightMap.put("down",weightMap.get("down"));
//////                if(canPlaceBomb("down",e)){
//////                    placeBomb(e);
//////                }
////            }
////        }
////
////        else if(e.direction == Direction.LEFT){
////            roleLeftCol = (roleLeftX-e.speed)/Panel.tileSize;
////            tileNum1 = panel.Map.canvas[roleTopRow][roleLeftCol];
////            tileNum2 = panel.Map.canvas[roleBottomRow][roleLeftCol];
////
////            bombCheck(e,"left");
////
////            if(tileNum1 == 0 || tileNum2 == 0){
////                //heuristic = Math.sqrt(Math.pow((e.posX/Panel.tileSize-panel.player.posX/Panel.tileSize),2)+Math.pow((e.posY/Panel.tileSize-panel.player.posY/Panel.tileSize),2));
////                //heuristic = Math.abs(e.posX-panel.player.posX)+Math.abs(e.posY-panel.player.posY);
////                //weightMap.put("left", weightMap.get("left")-heuristic);
////                weightMap.put("left", weightMap.get("left")+15);
////            }
////            else if(tileNum1 == 1 || tileNum2 == 1){
////                e.collisionDetected = true;
////                //weightMap.put("left",weightMap.get("left"));
////            }
////            else if(tileNum1 == 2 || tileNum2 == 2){
////                e.collisionDetected = true;
////                //weightMap.put("left",weightMap.get("left"));
//////                if(canPlaceBomb("left",e)){
//////                    placeBomb(e);
//////                }
////            }
////        }
////
////        else if(e.direction == Direction.RIGHT){
////            roleRightCol = (roleRightX+e.speed)/Panel.tileSize;
////            tileNum1 = panel.Map.canvas[roleTopRow][roleRightCol];
////            tileNum2 = panel.Map.canvas[roleBottomRow][roleRightCol];
////
////            bombCheck(e,"right");
////
////            if(tileNum1 == 0 || tileNum2 == 0){
////                //heuristic = Math.sqrt(Math.pow((e.posX/Panel.tileSize-panel.player.posX/Panel.tileSize),2)+Math.pow((e.posY/Panel.tileSize-panel.player.posY/Panel.tileSize),2));
////                //heuristic = Math.abs(e.posX-panel.player.posX)+Math.abs(e.posY-panel.player.posY);
////                //weightMap.put("right", weightMap.get("right")-heuristic);
////                weightMap.put("right", weightMap.get("right")+15);
////            }
////            else if(tileNum1 == 1 || tileNum2 == 1){
////                e.collisionDetected = true;
////                //weightMap.put("right",weightMap.get("right"));
////            }
////            else if(tileNum1 == 2 || tileNum2 == 2){
////                e.collisionDetected = true;
////                //weightMap.put("right",weightMap.get("right"));
//////                if(canPlaceBomb("right",e)){
//////                    placeBomb(e);
//////                }
////            }
////        }
////    }
//
//    public void avoidBomb(enemyAI e,String direction){
//        for(String s: directionMap.keySet()){
//            if(!s.equals(direction) && !bombCheck(e,s)) e.directionSet = s;
//        }
//    }
//
//    public boolean bombCheck(enemyAI e, String direction){
//        for(bomb b: panel.bombCopyOnWriteArrayList){
//            int bombLeftX = b.posX;
//            int bombTopY = b.posY;
//            int bombLeftCol = bombLeftX/Panel.tileSize;
//            int bombTopRow = bombTopY/Panel.tileSize;
//            if(direction.equals("up")){
//                if(bombLeftCol == e.posX/Panel.tileSize && (e.posY/Panel.tileSize-bombTopRow)<=1){
//                    e.collisionDetected = true;
//                    return true;
//                    //weightMap.put(direction,weightMap.get(direction)-999999.0);
//                }
//                return false;
//            }
//            else if(direction.equals("down")){
//                if(bombLeftCol == e.posX/Panel.tileSize && (bombTopRow-e.posY/Panel.tileSize)<=2){
//                    e.collisionDetected = true;
//                    return true;
//                    //weightMap.put(direction,weightMap.get(direction)-999999.0);
//                }
//                return false;
//            }
//            else if(direction.equals("left")){
//                if(bombTopRow == e.posY/Panel.tileSize && (e.posX/Panel.tileSize-bombLeftCol)<=2){
//                    e.collisionDetected = true;
//                    return true;
//                    //weightMap.put(direction,weightMap.get(direction)-999999.0);
//                }
//                return false;
//            }
//            else if(direction.equals("right")){
//                if(bombTopRow == e.posY/Panel.tileSize && (bombLeftCol-e.posX/Panel.tileSize)<=2){
//                    e.collisionDetected = true;
//                    return true;
//                    //weightMap.put(direction,weightMap.get(direction)-999999.0);
//                }
//                return false;
//            }
//        }
//        return false;
//    }
//
//
////    public boolean canPlaceBomb(String direction,enemyAI e,int indicator){
////        boolean canPlace = false;
////        int roleLeftX = e.posX+e.collisionArea.x;
////        int roleRightX = roleLeftX+e.collisionArea.width;
////        int roleTopY = e.posY+e.collisionArea.y;
////        int roleBottomY = roleTopY+e.collisionArea.height;
////
////        int roleLeftCol = roleLeftX/Panel.tileSize;
////        int roleRightCol = roleRightX/Panel.tileSize;
////        int roleTopRow = roleTopY/Panel.tileSize;
////        int roleBottomRow = roleBottomY/Panel.tileSize;
////
////        int tileNum1, tileNum2, tileNum3, tileNum4;
////
////        if(indicator == 3){
////
////        }
////
////
////        if(direction.equals("up")){
////            for(String s: weightMap.keySet()){
////                if(s.equals("down")){
////                    tileNum1 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("left")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-1,0)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-1,0)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-2,0)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-2,0)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("right")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)) {
////                        canPlace = true;
////                        weightMap.put(s, weightMap.get(s) + 999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////            }
////        }
////
////        if(direction.equals("down")){
////            for(String s: weightMap.keySet()){
////                if(s.equals("up")){
////                    tileNum1 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("left")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-1,0)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-1,0)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-2,0)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-2,0)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("right")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////            }
////        }
////        if(direction.equals("left")){
////            for(String s: weightMap.keySet()){
////                if(s.equals("up")){
////                    tileNum1 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("down")){
////                    tileNum1 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("right")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+1,Panel.numberOfColumn-1)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.min(roleRightCol+2,Panel.numberOfColumn-1)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////            }
////        }
////        if(direction.equals("right")){
////            for(String s: weightMap.keySet()){
////                if(s.equals("up")){
////                    tileNum1 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.max(roleTopRow-1,0)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.max(roleTopRow-2,0)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("down")){
////                    tileNum1 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum2 = panel.Map.canvas[Math.min(roleTopRow+1,Panel.numberOfRow-1)][roleRightCol];
////                    tileNum3 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleLeftCol];
////                    tileNum4 = panel.Map.canvas[Math.min(roleTopRow+2,Panel.numberOfRow-1)][roleRightCol];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////                if(s.equals("left")){
////                    tileNum1 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-1,0)];
////                    tileNum2 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-1,0)];
////                    tileNum3 = panel.Map.canvas[roleTopRow][Math.max(roleLeftCol-2,0)];
////                    tileNum4 = panel.Map.canvas[roleBottomRow][Math.max(roleLeftCol-2,0)];
////                    if((tileNum1 == 0 || tileNum2 == 0) && (tileNum3 == 0 || tileNum4 == 0)){
////                        canPlace = true;
////                        weightMap.put(s,weightMap.get(s)+999.0);
////                        e.collisionDetected = false;
////                    }
////                }
////            }
////        }
////        return canPlace;
////    }
//
//    private void placeBomb(enemyAI e){
//        placeBombWhenInteractWithPlayer(e);
//        bomb b = new bomb(e.posX, e.posY);
//        panel.bomblist.add(b);
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                panel.fireSetter.addFire(b);
//                panel.bomblist.remove(b);
//            }
//        },new Date(System.currentTimeMillis()+1500));
//    }
//
//    private void placeBombWhenInteractWithPlayer(enemyAI e){
//        e.collisionArea = new Rectangle(e.posX,e.posY,Panel.tileSize,Panel.tileSize);
//        panel.player.collisionArea = new Rectangle(panel.player.posX,panel.player.posY,Panel.tileSize,Panel.tileSize);
//        if(e.collisionArea.intersects(panel.player.collisionArea)) panel.bombSetter.addBomb(e);
//    }
//
//}
//
