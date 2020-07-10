#!/usr/bin/env python
#from _future_ import print_function
import roslib
import sys
import rospy
from std_msgs.msg import Float64
from sensor_msgs.msg import LaserScan
class motor_control:
    def __init__(self):
        self.rate  = rospy.Rate(20)
        self.timer_to_sending_data = 0 

        self.speed = rospy.Publisher('commands/motor/speed', Float64 , queue_size= 1)
        self.postion = rospy.Publisher('commands/motor/postion', Float64 , queue_size= 1)
    
    def callback(data):
        for i in range (180,185):
            lidar_dis = data.ranges[i]
        while not rospy.is_shutdown():
            if lidar_dis < 1:
                    print(1)
                    self.speed_value = 1000
                    self.postion_value = 1.0
                    self.speed.publish(self.speed_value)
                    self.postion.publish(self.postion_value)
            else:
                    print(1200)
                    self.speed_value = 1200
                    self.postion_value = 1.0
                    self.speed.publish(self.speed_value)
                    self.postion.publish(self.postion_value)
        ##print("%dth value" %i,lidar_dis)
            print('')
    def listener():
    # In ROS, nodes are uniquely named. If two nodes with the same
    # name are launched, the previous one is kicked off. The
    # anonymous=True flag means that rospy will choose a unique
    # name for our 'listener' node so that multiple listeners can
    # run simultaneously.
        rospy.init_node('rp', anonymous=True)

        rospy.Subscriber('scan', LaserScan, callback)

    # spin() simply keeps python from exiting until this node is stopped
        rospy.spin()
def main(args):
        rospy.init_node('motor_control', anonymous= True)
        motor_control()
        rospy.spin()

if __name__ == '__main__':
    main(sys.argv)
