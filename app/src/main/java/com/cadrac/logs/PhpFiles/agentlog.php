<?php

	header('Access-Control-Allow-Origin: *');
	header('Access-Control-Allow-Methods: POST, GET, OPTIONS');

	if($_SERVER['REQUEST_METHOD']=="POST" || $_SERVER['REQUEST_METHOD'] == "GET")
		{

		  $log_msg	= $_REQUEST['logmsg'];

		   $log_filename = "agentlogs";

		    if (!file_exists($log_filename))
		    {
			// create directory/folder uploads.

			mkdir($log_filename, 0777, true);

		    }
		    $log_file_data = $log_filename.'/log_' . date('d-M-Y') . '.log';

		    file_put_contents($log_file_data, $log_msg . "\n", FILE_APPEND);
		    $result['status']='true';

	  }else
		{
			$result['status']='FALSE';
			$result['message']='Request method wrong!';
		}
     header("Content-Type:application/json");
     echo json_encode($result);
    ?>